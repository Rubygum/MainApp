package com.rubygum.mainapp.splash;

import android.animation.Animator;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.rubygum.mainapp.BaseActivity;
import com.rubygum.mainapp.R;
import com.rubygum.mainapp.login.LoginActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    private RelativeLayout rootLayout;
    private float widthPixels;
    private float heightPixels;
    private Random random = new Random();
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        logo = (ImageView) findViewById(R.id.logo);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        widthPixels = metrics.widthPixels / 2;
        heightPixels = metrics.heightPixels / 2;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 150);


        Animation scale = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setRepeatCount(Animation.INFINITE);
        scale.setRepeatMode(Animation.REVERSE);
        scale.setFillAfter(true);
        scale.setFillEnabled(true);
        scale.setDuration(800);
        scale.setStartTime(3000);
        logo.startAnimation(scale);


        logo.postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.finish();
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(intent);
            }
        }, 3000);


    }

    final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            SplashActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    addNewCircle();
                }
            });
        }
    };


    private void addNewCircle() {

        float deltaY = random.nextFloat() * (heightPixels / 8f);
        float deltaSize = random.nextFloat() * (heightPixels / 30f);
        float alpha = 155 + 255 * random.nextFloat();

        long alphaDuration = (long) (500 + 500 * random.nextFloat());
        long alphaDelay = (long) (1000 + 500 * random.nextFloat());

        final CircleView circleView = new CircleView(this, rootLayout, 0, heightPixels - deltaY - 20, heightPixels / 30f + deltaSize, (int) alpha);
        rootLayout.addView(circleView);


        Animation rotation = new RotateAnimation(0f, -190f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.5f);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setDuration(2000);

        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                circleView.post(new Runnable() {
                    @Override
                    public void run() {
                        rootLayout.removeView(circleView);
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        circleView.startAnimation(rotation);
    }

    @Override
    protected int getContainerId() {
        return 0;
    }
}
