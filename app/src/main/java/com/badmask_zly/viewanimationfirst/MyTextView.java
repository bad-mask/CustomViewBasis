package com.badmask_zly.viewanimationfirst;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;

/**
 * Created by badmask_zly on 2017/5/18.
 */

public class MyTextView extends ViewGroup {

    private Context mContext;

    private Scroller mScroller;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        mScroller = new Scroller(mContext);
        ImageView slide = new ImageView(mContext);
        slide.setBackgroundResource(R.mipmap.ic_launcher);
        slide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mScroller.startScroll(getScrollX(), 0, getMeasuredWidth() / 2, 0, 500);
                invalidate();
            }
        });
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View view = getChildAt(0);
        view.layout(0, 0, getMeasuredWidth() / 2, getMeasuredHeight());

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.e("error", "computeScroll");
        if (mScroller.computeScrollOffset()) {
            Log.e("error", "computeScroll    ======");
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    private void smoothScrollTo(float dstX, int dstY) {
        int scrollX = getScrollX();
        float delta = dstX - scrollX;
        mScroller.startScroll(scrollX, 0, (int) delta, 0, 1000);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                //  smoothScrollTo(event.getX(),0);
                getX();
                event.getX();
                event.getRawX();

                break;
        }
        return super.onTouchEvent(event);
    }
}
