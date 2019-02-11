package com.common.shy.interviewmodule.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CellView extends View {

    private Paint mPaintDead;
    private Paint mPaintAlive;
    private Context mContext;
    private int mWidth;
    private int mCountX = 70;
    private int mCountY = 70;
    private int mCellWidth = 12;
    private int mGap;

    private int[][] dish = new int[mCountX][mCountY];
    private int[][] propagated = new int[mCountX][mCountY];

    private List<CellBean> mData = new ArrayList<>(mCountX * mCountY);

    private boolean isActive;

    private void init(Context context) {
        mContext = context;
        mPaintDead = new Paint();
        mPaintDead.setAntiAlias(true);
        mPaintDead.setStyle(Paint.Style.FILL);
        mPaintDead.setColor(Color.GRAY);
        mPaintAlive = new Paint();
        mPaintAlive.setAntiAlias(true);
        mPaintAlive.setStyle(Paint.Style.FILL);
        mPaintAlive.setColor(Color.GREEN);
        mWidth = getMobileWidth(mContext);
        mGap = (mWidth - mCountX * mCellWidth) / (mCountX - 1);
        for (int i = 0; i < mCountX; i++) {
            for (int j = 0; j < mCountY; j++) {
                CellBean cb = new CellBean(i, j);
                mData.add(cb);

                dish[i][j] = Math.random() < 0.15 ? 1 : 0;
            }
        }
    }

    public CellView(Context context) {
        super(context);
        init(context);
    }

    public CellView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CellView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left;
        int right;
        int top;
        int bottom;
        for (CellBean cb : mData) {
            left = cb.mCellX * mCellWidth + cb.mCellX * mGap;
            right = left + mCellWidth;
            top = cb.mCellY * mCellWidth + cb.mCellY * mGap;
            bottom = top + mCellWidth;
            canvas.drawRect(left, top, right, bottom, dish[cb.mCellX][cb.mCellY] == 0 ? mPaintDead : mPaintAlive);
        }

        if (isActive) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    propagate();
                }
            }, 500);
        }
    }

    public void startPropagate() {
        isActive = true;
        propagate();
    }

    public void stop() {
        isActive = false;
    }

    private void propagate() {
        for (int i = 0; i < mCountX; i++) {
            for (int j = 0; j < mCountY; j++) {
                singleCellPropagate(i, j);
            }
        }
        int[][] temp = propagated;
        propagated = dish;
        dish = temp;
        invalidate();
    }

    private void singleCellPropagate(int x, int y) {
        int count = 0;

        for (int i = y - 1; i <= y + 1; i++) {
            if (i < 0 || i >= dish.length)
                continue;

            int[] row = dish[i];
            for (int j = x - 1; j <= x + 1; j++) {
                if (j < 0 || j >= row.length)
                    continue;

                count += dish[j][i];
            }
        }

        count -= dish[x][y];

        if (count == 3) {
            propagated[x][y] = 1;
        } else if (count == 2) {
            propagated[x][y] = dish[x][y];
        } else {
            propagated[x][y] = 0;
        }
    }

    public static int getMobileWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels; // 得到宽度
        return width;

    }

    public static class CellBean {
        public int mCellX;
        public int mCellY;

        public CellBean(int mCellX, int mCellY) {
            this.mCellX = mCellX;
            this.mCellY = mCellY;
        }
    }

}
