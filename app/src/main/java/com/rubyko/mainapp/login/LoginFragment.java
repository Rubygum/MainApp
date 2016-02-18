package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubyko.mainapp.BaseFragment;
import com.rubyko.mainapp.R;

/**
 * Created by alex on 16.02.16.
 */
public final class LoginFragment extends BaseFragment<LoginActivity> {

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_logining, pContainer, false);
        return view;
    }

}