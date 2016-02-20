package com.rubyko.mainapp.login.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;

import com.rubyko.mainapp.R;

import io.saeid.fabloading.LoadingView;

/**
 * Created by alex on 20.02.16.
 */
public class RubykoLoadingAnimation extends io.saeid.fabloading.LoadingView {



    public RubykoLoadingAnimation(Context context) {
        super(context);
    }

    public RubykoLoadingAnimation(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public RubykoLoadingAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void startAnimation() {
        super.startAnimation();

    }



}

