package com.test.scroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.scroll.widget.SmoothScrollButton;
import com.test.scroll.widget.SmoothScrollCircle;
import com.test.scroll.widget.SmoothScrollTextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Button mBtn2;
    private ImageView mIv;
    private LinearLayout mLinearLayout;
    private SmoothScrollCircle mSSCircle;
    private SmoothScrollButton mSSButton;
    private SmoothScrollTextView mSSTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mIv = (ImageView) findViewById(R.id.iv);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll);
        mSSCircle = (SmoothScrollCircle) findViewById(R.id.ssCircle);
        mSSButton = (SmoothScrollButton) findViewById(R.id.ssButton);
        mSSTv = (SmoothScrollTextView) findViewById(R.id.ssTv);
    }

    public void instantScroll(View view) {
        if (view.getId() == R.id.btn_instantscroll) {
            mTv.scrollBy(-50, 0);
            mBtn2.scrollBy(-50, 0);
            mIv.scrollBy(-50, 0);
            mLinearLayout.scrollBy(-50, 0);
        }
    }

    public void smoothScroll(View view) {
        if (view.getId() == R.id.btn_smoothScroll) {
            mSSCircle.smoothScrollTo(mSSCircle.getScrollX() - 100, mSSCircle.getScrollY(), 2000);
            mSSButton.smoothScrollTo(mSSButton.getScrollX() - 100, mSSButton.getScrollY(), 2000);
            mSSTv.smoothScrollTo(mSSTv.getScrollX() - 100, mSSTv.getScrollY(), 2000);
        }
    }
}
