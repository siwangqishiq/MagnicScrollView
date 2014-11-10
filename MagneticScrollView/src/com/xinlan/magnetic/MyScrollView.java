package com.xinlan.magnetic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView
{
    private ScrollViewListener scrollViewListener = null;
    private View magnicView;
    private boolean isMagnicShow = false;

    private boolean isAdjust = false;

    public MyScrollView(Context context)
    {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public MyScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setMagnicView(View view)
    {
        magnicView = view;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener)
    {
        this.scrollViewListener = scrollViewListener;
    }

    private boolean isMagnicViewShow()
    {
        int delta = magnicView.getTop() - (getScrollY()+getHeight());
        if(delta<0&& delta>-(getHeight()+magnicView.getHeight())){
            //System.out.println("œ‘ æ");
            return true;
        }else{
            //System.out.println("none");
            return false;
        }
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy)
    {
        super.onScrollChanged(x, y, oldx, oldy);
        if(Math.abs(oldy-y)<4){//ª¨∂ØÕ£÷π
            if(isMagnicViewShow()&& isAdjust){
                magnicViewToTop();
            }
        }
        // System.out.println(this.getScrollY()+"    "+this.getTop());
        if (scrollViewListener != null)
        {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }
    
    private boolean shouldAjustMagnic(){
        return false;
    }
    
    public void magnicViewToBottom(){
        int toY = (int) magnicView.getY() - getHeight()
                + magnicView.getHeight();
        smoothScrollTo(0, toY);
    }
    
    public void magnicViewToTop(){
        //int y = (int) magnicView.getY() + magnicView.getHeight();
        int y = (int) magnicView.getY();
        smoothScrollTo(0, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                isAdjust = false;
                // System.out.println("down");
                break;
            case MotionEvent.ACTION_MOVE:
                isAdjust = false;
                // System.out.println("move");
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // System.out.println("up");
                // int y = (int) event.getY();
                if(isMagnicViewShow()&& isAdjust){
                    magnicViewToTop();
                }
                isAdjust = true;
                break;
        }// end switch
        return super.onTouchEvent(event);
    }

    public static interface ScrollViewListener
    {
        void onScrollChanged(ScrollView scrollView, int x, int y, int oldx,
                int oldy);
    }
}// end class
