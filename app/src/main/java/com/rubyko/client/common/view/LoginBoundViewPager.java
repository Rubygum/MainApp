package com.rubyko.client.common.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by alex on 26.02.16.
 */
public class LoginBoundViewPager extends RubykoParallaxViewPager {


    private GestureDetector detector;
    private int leftBoundPositionInclusive = 1;
    private final float boundOffset = 0.5f;
    private float oldX = 0f;

    private enum Direction {RIGHT, LEFT}

    public void setLeftBound(int pos) {
        this.leftBoundPositionInclusive = pos;
    }

    int screenWidth;
    int screenHeight;

    void init(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }


    public LoginBoundViewPager(Context context) {
        super(context);
        init((Activity) context);
    }

    public LoginBoundViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init((Activity) context);
    }

    private Direction returnValue = null;


    @Override
    public boolean onTouchEvent(MotionEvent ev) {


        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        {
            if (oldX > ev.getX()) {
                returnValue = Direction.LEFT;
            } else {
                returnValue = Direction.RIGHT;
            }
            Log.w("" + returnValue, "" + returnValue);
            oldX = ev.getX();
        }

        if (isFakeDragging() && returnValue == Direction.LEFT && position != leftBoundPositionInclusive) {
            endFakeDrag();
        } else if (isFakeDragging() && returnValue == Direction.RIGHT && position > leftBoundPositionInclusive){
           endFakeDrag();
        } else if (isFakeDragging() && returnValue == Direction.LEFT && position == leftBoundPositionInclusive) {
           endFakeDrag();
        }
        return super.onInterceptTouchEvent(ev);
    }

    private int position;

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        this.position = position;


        if (oldX > offset) {
            returnValue = Direction.LEFT;
        } else {
            returnValue = Direction.RIGHT;
        }
        Log.w("" + returnValue, "" + returnValue);
        oldX = offset;

        Log.w("offset" + offset, "offsetPixels" + offsetPixels + " position " + position);
        if (position == leftBoundPositionInclusive) {
            beginFakeDrag();
        }


        super.onPageScrolled(position, offset, offsetPixels);
    }
}
