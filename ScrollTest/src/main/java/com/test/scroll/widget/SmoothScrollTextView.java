package com.test.scroll.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * 内容可以平滑移动的 TextView
 *
 * @author zhangzhiyi
 * @version 1.0
 * @createTime 2016/3/31 11:41
 * @projectName ScrollTest
 */
public class SmoothScrollTextView extends TextView {

    private Scroller mScroller;

    public SmoothScrollTextView(Context context) {
        super(context);
        init(context);
    }

    public SmoothScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SmoothScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
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
}
