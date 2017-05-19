package com.badmask_zly.viewanimationfirst;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_first;

   Scroller mScroller ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // tv_first= (TextView) findViewById(R.id.tv_first);

        mScroller =new Scroller(getApplicationContext());

        tv_first.getX();

      //  tv_first.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //smooth_scrollby();
//            }
//        });

    }

    /**
     * 直接滑动
     * 只是在 view 里滑动
     */
    private void smooth_scrollby(){
        tv_first.scrollBy(10,100);
    }


}



















