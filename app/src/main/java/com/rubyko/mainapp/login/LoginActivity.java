package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.os.Handler;

import com.rubyko.mainapp.BaseActivity;
import com.rubyko.mainapp.R;


/**
 * Created by yegor on 14/02/16.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addFragment(new Bundle(), LoginFragment.class);
            }
        }, 1000);
    }

    @Override
    protected int getContainerId() {
        return R.id.activityContainer;
    }

}
