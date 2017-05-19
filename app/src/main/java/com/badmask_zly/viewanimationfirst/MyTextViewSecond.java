package com.badmask_zly.viewanimationfirst;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by badmask_zly on 2017/5/19.
 */

public class MyTextViewSecond extends android.support.v7.widget.AppCompatTextView {

    private int mLastX;
    private int mLastY;


    public MyTextViewSecond(Context context) {
        this(context, null);
    }

    public MyTextViewSecond(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextViewSecond(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();//相对于屏幕左上角的 x 坐标值
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                int translationX = (int) ViewHelper.getTranslationX(this) + deltaX;
                int translationY = (int) ViewHelper.getTranslationY(this) + deltaY;
                ViewHelper.setTranslationX(this,translationX);
                ViewHelper.setTranslationY(this,translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        mLastX=x;
        mLastY=y;

        return true;
    }
}
