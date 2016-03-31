package com.test.scroll.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * 内容可以平滑移动的圆
 *
 * @author zhangzhiyi
 * @version 1.0
 * @createTime 2016/3/31 10:32
 * @projectName ScrollTest
 */
public class SmoothScrollCircle extends View {
    // 默认宽高300px
    private static final int DEF_SIZE = 300;
    private Scroller mScroller;
    private Paint mPaint;

    public SmoothScrollCircle(Context context) {
        super(context);
        init(context);
    }

    public SmoothScrollCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SmoothScrollCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#88ff0000"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(1);
    }

    /**
     * 平滑移动
     * @param destX 目标位置的x坐标
     * @param destY 目标位置的y坐标
     * @param durationTimeMillis 该平滑移动一共用的时间, 单位毫秒
     */
    public void smoothScrollTo(int destX, int destY, int durationTimeMillis) {
        int startX = getScrollX();
        int startY = getScrollY();
        int dx = destX - startX;
        int dy = destY - startY;
        // 开始进行平滑移动
        mScroller.startScroll(startX, startY, dx, dy, durationTimeMillis);
        // 必须手动要求重绘, 系统才会开始重绘
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            // 每次都必须手动要求重绘
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int measuredWidth = widthSpecSize;
        int measuredHeight = heightSpecSize;

        if (widthSpecMode == MeasureSpec.AT_MOST) {
            measuredWidth = DEF_SIZE;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST) {
            measuredHeight = DEF_SIZE;
        }

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        // 除去padding后的净宽高
        int nestedWidth = getWidth() - paddingLeft - paddingRight;
        int nestedHeight = getHeight() - paddingTop - paddingBottom;

        float radius = Math.min(nestedWidth, nestedHeight) / 2.0f;
        // 绘制时要考虑padding
        canvas.drawCircle(paddingLeft + nestedWidth / 2.0f, paddingTop + nestedHeight / 2.0f, radius, mPaint);
    }
}
