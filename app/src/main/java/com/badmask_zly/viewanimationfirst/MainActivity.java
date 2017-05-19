package com.badmask_zly.viewanimationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Scroller;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_first;

   Scroller mScroller ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScroller =new Scroller(getApplicationContext());

    }

    /**
     * 直接滑动
     * 只是在 view 里滑动
     */
    private void smooth_scrollby(){
        tv_first.scrollBy(10,100);
    }


}



















