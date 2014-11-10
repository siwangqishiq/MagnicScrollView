package com.xinlan.magnetic;

import com.xinlan.magnetic.MyScrollView.ScrollViewListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ScrollView;

public class MainActivity extends Activity
{
    private MagnicScrollView scrollView;
    private View magView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (MagnicScrollView) findViewById(R.id.scroll);
        magView = findViewById(R.id.mag);

        magView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               
            }
        });
        scrollView.setMagView(magView);
    }
}// end class
