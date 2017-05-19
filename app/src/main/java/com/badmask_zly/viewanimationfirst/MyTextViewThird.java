package com.badmask_zly.viewanimationfirst;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by badmask_zly on 2017/5/19.
 */

public class MyTextViewThird extends android.support.v7.widget.AppCompatTextView implements View.OnTouchListener {

    private Context mContext;
    private Scroller scroller;

    public MyTextViewThird(Context context) {
        super(context);
        init(context);
    }


    public MyTextViewThird(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyTextViewThird(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.setOnTouchListener(this);
        scroller=new Scroller(context);
    }


    private void smoothScrollTo(int destX,int destY){
        int scrollX=this.getScrollX();
        int scrollY=this.getScrollY();
        Log.e("zly","scrollX   =   "+scrollX+"  scrollY   =   "+scrollY);
        int deltaX=destX-scrollX;
        int deltaY=destY-scrollY;
        scroller.startScroll(scrollX,scrollY,deltaX,deltaY,1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()){
            this.scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action=event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.e("zly","-(int)event.getX()   =   "+(-(int)event.getX())+"   -(int)event.getY()   =   "+(-(int)event.getY()));
                smoothScrollTo(-(int)event.getX(),-(int)event.getY());
                break;
            case  MotionEvent.ACTION_MOVE:
                smoothScrollTo(-(int)event.getX(),-(int)event.getY());
                break;
        }
        return true;
    }
}
