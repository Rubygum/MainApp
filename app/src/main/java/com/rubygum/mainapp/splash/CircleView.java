package com.rubygum.mainapp.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by yegor on 14/02/16.
 */
public class CircleView extends ImageView {

    private final float radius;
    private final Paint paint;

    public CircleView(Activity context, ViewGroup parent, float x, float y, float radius, int alpha) {
        super(context);
        this.setX(x);
        this.setY(y);
        this.radius = radius;
        this.paint = new Paint();
        this.paint.setColor(Color.BLACK);
        this.paint.setAlpha(alpha);
        this.setLayoutParams(parent.getLayoutParams());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.getX() - radius , this.getY(), radius, paint);
    }

}
