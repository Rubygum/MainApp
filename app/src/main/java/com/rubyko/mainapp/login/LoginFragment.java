package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.rubyko.mainapp.BaseFragment;
import com.rubyko.mainapp.R;

/**
 * Created by alex on 16.02.16.
 */
public final class LoginFragment extends BaseFragment<LoginActivity> implements View.OnClickListener{

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_login, pContainer, false);
        final Button loginDoneBtn = (Button) view.findViewById(R.id.loginDoneBtn);
        loginDoneBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginDoneBtn:
                getFragmentActivity().showFragment(new Bundle(), AuthorizationFragment.class);
        }
    }

}