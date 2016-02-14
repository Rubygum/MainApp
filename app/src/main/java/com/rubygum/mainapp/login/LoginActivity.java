package com.rubygum.mainapp.login;

import android.os.Bundle;

import com.rubygum.mainapp.BaseActivity;
import com.rubygum.mainapp.R;

/**
 * Created by yegor on 14/02/16.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addFragment(new Bundle(), LoginFragment.class);
    }

    @Override
    protected int getContainerId() {
        return R.id.activityContainer;
    }

}
