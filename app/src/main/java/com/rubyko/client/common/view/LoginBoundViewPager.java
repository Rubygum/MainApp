package com.rubyko.client.common.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rubyko.client.common.RubykoActivity;

/**
 * Created by alex on 26.02.16.
 */
public class LoginBoundViewPager extends RubykoParallaxViewPager {


    private GestureDetector detector;
    private int leftBoundPositionInclusive = -1;
    private final float boundOffset = 0.5f;


    private enum Direction {RIGHT, LEFT}


    private boolean allow = true;
    private int position = 0;


    void disableMultitouch(ViewGroup v) {
        v.setMotionEventSplittingEnabled(false);
        for (int i = 0; i < v.getChildCount(); i++) {
            View child = v.getChildAt(i);
            if (child instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) child;
                disableMultitouch(viewGroup);
            }
        }

    }

    public void setLeftBound(int pos, final boolean leftBound) {


        disableMultitouch(this);

        this.leftBoundPositionInclusive = pos;
        this.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, final float positionOffset, int positionOffsetPixels) {
                LoginBoundViewPager.this.position = position;
                LoginBoundViewPager.this.post(new Runnable() {
                    @Override
                    public void run() {
                        if (leftBound && LoginBoundViewPager.this.position < leftBoundPositionInclusive) {
                            setCurrentItem(leftBoundPositionInclusive);
                            if (positionOffset < 0.95f) {
                                allow = false;
                            } else {
                                allow = true;
                            }
                        }
                    }
                });
            }

            @Override
            public void onPageSelected(int position) {
                LoginBoundViewPager.this.position = position;
                LoginBoundViewPager.this.post(new Runnable() {
                    @Override
                    public void run() {
                        if (leftBound && LoginBoundViewPager.this.position < leftBoundPositionInclusive) {
                            setCurrentItem(leftBoundPositionInclusive);
                        }
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    float oldX;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            switch (ev.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:
                    System.out.println("ACTION_UP");
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    System.out.println("ACTION_POINTER_UP");
                    break;
                case MotionEvent.ACTION_MOVE: {
                    if (!allow) {
                        ev.setLocation(oldX, 0);
                        System.out.println(oldX);
                    }
                    oldX = MotionEventCompat.getX(ev, 0);
                }
                break;
                case MotionEvent.ACTION_DOWN:
                    System.out.println("ACTION_DOWN");
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    return false;
            }

            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean arrowScroll(int direction) {
        return super.arrowScroll(direction);
    }

    public LoginBoundViewPager(Context context) {
        super(context);
    }

    public LoginBoundViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
