package com.rubyko.mainapp.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.rubyko.mainapp.BlurFragment;
import com.rubyko.mainapp.MainActivity;
import com.rubyko.mainapp.R;

/**
 * Created by alex on 19.02.16.
 */
public class LoadingFragment extends BlurFragment<MainActivity> {
    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_loading, pContainer, false);
        return view;
     }
}

