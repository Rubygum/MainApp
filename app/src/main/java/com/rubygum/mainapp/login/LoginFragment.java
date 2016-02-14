package com.rubygum.mainapp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubygum.mainapp.BaseActivity;
import com.rubygum.mainapp.BaseFragment;
import com.rubygum.mainapp.R;

/**
 * Created by yegor on 14/02/16.
 */
public class LoginFragment extends BaseFragment<LoginActivity> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

}
