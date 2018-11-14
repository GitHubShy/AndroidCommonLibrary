package com.common.shy.basemodule.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HandDrawView extends View {

    private Paint mPaint;
    private List<Path> mPathList = new ArrayList<>();
    private Path mCurrentPath = new Path();
    private float mLastX;
    private float mLastY;

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.RED);

    }

    public HandDrawView(Context context) {
        super(context);
        init();
    }

    public HandDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HandDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
//                mCurrentPath = new Path(); // 新的涂鸦
                mPathList.add(mCurrentPath); // 添加的集合中
                mCurrentPath.moveTo(e.getX(), e.getY());
                mLastX = e.getX();
                mLastY = e.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float x = e.getX();
                final float y = e.getY();

                final float previousX = mLastX;
                final float previousY = mLastY;

                final float dx = Math.abs(x - previousX);
                final float dy = Math.abs(y - previousY);

                //两点之间的距离大于等于3时，生成贝塞尔绘制曲线
                if (dx >= 3 || dy >= 3)
                {
                    //设置贝塞尔曲线的操作点为起点和终点的一半
                    float cX = (x + previousX) / 2;
                    float cY = (y + previousY) / 2;

                    //二次贝塞尔，实现平滑曲线；previousX, previousY为操作点，cX, cY为终点
                    mCurrentPath.quadTo(previousX, previousY, cX, cY);

                    //第二次执行时，第一次结束调用的坐标值将作为第二次调用的初始坐标值
                    mLastX = x;
                    mLastY = y;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mCurrentPath,mPaint);
    }

    public void clear () {
        mCurrentPath = new Path();
        invalidate();
    }
}
