package com.xinlan.magnetic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class MagnicScrollView extends ScrollView
{
    private View magView;
    private boolean isShouldAdhere = false;// 标示是否需要做粘附操作

    public MagnicScrollView(Context context)
    {
        super(context);
    }

    public MagnicScrollView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public MagnicScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy)
    {
        super.onScrollChanged(x, y, oldx, oldy);

        if (isMagViewCanVisible())// 磁性控件可见
        {
            // 吸附效果
            int dy = magView.getTop() - this.getScrollY();
            int mid = getHeight() / 2 - magView.getHeight();
            if (dy < mid && isShouldAdhere)// 粘附在上部
            {
                toMagnicOnTop();
            }
            else if (dy >= mid && isShouldAdhere)// 粘附在下部
            {
                toMagnicOnBottom();
            }// end if
            isShouldAdhere = false;
        }
    }

    public void setMagView(View magView)
    {
        this.magView = magView;
    }

    public void toMagnicOnTop()
    {
        smoothScrollTo(0, magView.getTop());
    }

    public void toMagnicOnBottom()
    {
        int toY = magView.getTop() - this.getHeight() + magView.getHeight();
        smoothScrollTo(0, toY);
    }

    private boolean isMagViewCanVisible()
    {
        if (this.getScrollY() + this.getHeight() > magView.getTop()
                && this.getScrollY() < magView.getTop() + magView.getHeight())
        {
            // System.out.println("可见");
            return true;
        }

        // System.out.println("不可见");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isShouldAdhere = true;
                break;
        }// end switch
        return super.onTouchEvent(event);
    }
}// end class
