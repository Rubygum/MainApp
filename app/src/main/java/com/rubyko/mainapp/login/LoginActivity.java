package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.os.Handler;

import com.rubyko.mainapp.BaseActivity;
import com.rubyko.mainapp.R;

import fr.tvbarthel.lib.blurdialogfragment.BlurDialogEngine;
import tyrantgit.explosionfield.ExplosionField;


/**
 * Created by yegor on 14/02/16.
 */
public class LoginActivity extends BaseActivity implements  Runnable {

    private ExplosionField explosionField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        new Handler().postDelayed(this, 1000);
        explosionField = ExplosionField.attach2Window(this);
    }

    @Override
    protected int getContainerId() {
        return R.id.activityContainer;
    }

    @Override
    public void run() {
        replaceFragment(new Bundle(), LoginFragment.class);
        explosionField.explode(findViewById(R.id.logo));
    }
}
