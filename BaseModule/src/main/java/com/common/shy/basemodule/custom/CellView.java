package com.common.shy.basemodule.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.common.shy.commonutils.utils.DisplayUtil;
import com.common.shy.commonutils.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class CellView extends View {

    private Paint mPaint;
    private Context mContext;
    private int mWidth;
    private int mCountX = 70;
    private int mCountY = 70;
    private int mCellWidth = 12;
    private int mGap;

    private List<CellBean> mData = new ArrayList<>();

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mWidth = DisplayUtil.getMobileWidth(mContext);
        mGap = (mWidth - mCountX * mCellWidth) / (mCountX - 1);
        for (int i = 0; i < mCountX; i++) {
            for (int j = 0; j < mCountY; j++) {
                CellBean cb = new CellBean(i, j);
                mData.add(cb);
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
            Logger.e("11111111111111111", "mWidth=" + mWidth + "gap=" + mGap + "--left=" + left + "--right=" + right);
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
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
