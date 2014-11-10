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
    private MyScrollView scrollView;
    private View magView;
    private View firstView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstView = findViewById(R.id.first_view);

        scrollView = (MyScrollView) findViewById(R.id.scroll);
        magView = findViewById(R.id.mag);

        magView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               
            }
        });

        firstView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //scrollView.magnicViewToTop();
                //scrollView.magnicViewToBottom();
            }
        });

        //scrollView.setOnTouchListener(new TouchListener());
        //scrollView.setScrollViewListener(new Listener());
        
        scrollView.setMagnicView(magView);
    }
    
    private final class Listener implements ScrollViewListener
    {

        @Override
        public void onScrollChanged(ScrollView scrollView, int x, int y,
                int oldx, int oldy)
        {
            System.out.println(x+"   "+y +"   "+oldx+"   "+oldy);
            
        }
    }

//    private final class TouchListener implements OnTouchListener
//    {
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event)
//        {
////            System.out.println("bottom--->" + scrollView.getBottom() + "      "
////                    + scrollView.getTop() + "    " + scrollView.getHeight());
//            
//            //System.out.println("xxxxx");
//            
//            switch (event.getAction())
//            {
//                case MotionEvent.ACTION_DOWN:
//                    //System.out.println("down");
//                    break;
//                case MotionEvent.ACTION_MOVE:
//                    //System.out.println("move");
//                    break;
//                case MotionEvent.ACTION_UP:
//                case MotionEvent.ACTION_CANCEL:
//                    //System.out.println("up");
//                    int y = (int)event.getY();
//                    
//                    break;
//            }// end switch
//
//            return false;
//        }
//    }// end inner class

    // private final class ScrollListener implements OnScrollListener
    // {
    //
    // @Override
    // public void onScrollStateChanged(AbsListView view, int scrollState)
    // {
    //
    // }
    //
    // @Override
    // public void onScroll(AbsListView view, int firstVisibleItem,
    // int visibleItemCount, int totalItemCount)
    // {
    // int y = view.getScrollY();
    // System.out.println(y);
    // }
    // }//end inner class
}// end class
