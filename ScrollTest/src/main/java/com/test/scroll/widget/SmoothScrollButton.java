package com.test.scroll.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * 内容可以平滑移动的 Button
 *
 * @author zhangzhiyi
 * @version 1.0
 * @createTime 2016/3/31 12:05
 * @projectName ScrollTest
 */
public class SmoothScrollButton extends SmoothScrollTextView {
    public SmoothScrollButton(Context context) {
        super(context);
    }

    public SmoothScrollButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmoothScrollButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
