package com.rubyko.mainapp.login.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.rubyko.mainapp.BlurFragment;
import com.rubyko.mainapp.MainActivity;
import com.rubyko.mainapp.R;

import io.saeid.fabloading.LoadingView;

/**
 * Created by alex on 19.02.16.
 */
public class LoadingFragment extends BlurFragment<MainActivity> implements Runnable {

    private LoadingView mLoadingView;

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_loading, pContainer, false);

        mLoadingView = (LoadingView) view.findViewById(R.id.loading_view_repeat);
        boolean isLollipop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
        int marvel_1 = isLollipop?R.drawable.marvel_1_lollipop:R.drawable.marvel_1;
        int marvel_2 = isLollipop?R.drawable.marvel_2_lollipop:R.drawable.marvel_2;
        int marvel_3 = isLollipop?R.drawable.marvel_3_lollipop:R.drawable.marvel_3;
        int marvel_4 = isLollipop?R.drawable.marvel_4_lollipop:R.drawable.marvel_4;

        mLoadingView.addAnimation(Color.parseColor("#FFD200"),marvel_1,
                LoadingView.FROM_LEFT);
        mLoadingView.addAnimation(Color.parseColor("#2F5DA9"),marvel_2,
                LoadingView.FROM_TOP);
        mLoadingView.addAnimation(Color.parseColor("#FF4218"),marvel_3,
                LoadingView.FROM_RIGHT);
        mLoadingView.addAnimation(Color.parseColor("#C7E7FB"), marvel_4,
                LoadingView.FROM_BOTTOM);

        view.postDelayed(this, 5_00);
        return view;
    }

    @Override
    public void run() {
        mLoadingView.startAnimation();
        if(this.getView()!=null){
            this.getView().postDelayed(this, 5_00);
        }
    }

}

