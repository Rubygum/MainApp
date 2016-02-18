package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rubyko.mainapp.BaseActivity;
import com.rubyko.mainapp.R;

import tyrantgit.explosionfield.ExplosionField;


/**
 * Created by yegor on 14/02/16.
 */
public class LoginActivity extends BaseActivity implements  Runnable, FragmentManager.OnBackStackChangedListener {

    private ExplosionField explosionField;
    private ImageView mLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        new Handler().postDelayed(this, 1000);
        explosionField = ExplosionField.attach2Window(this);
        mLogo = (ImageView) findViewById(R.id.logo);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    @Override
    protected int getContainerId() {
        return R.id.activityContainer;
    }

    @Override
    public void run() {
        replaceFragment(new Bundle(), ChooseFragment.class);
    }

    public void showLogo(){
        mLogo.setVisibility(View.VISIBLE);
    }

    public void hideLogo(){
        mLogo.setVisibility(View.INVISIBLE);
    }



    @Override
    public void onBackStackChanged() {
        if(getSupportFragmentManager().getBackStackEntryCount() != 1){
            hideLogo();
        }
        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
            showLogo();
            destroy();
        }
    }

    private void destroy(){
        mLogo.postDelayed(new Runnable() {
            @Override
            public void run() {
                explosionField.explode(mLogo);
            }
        }, 500);
        mLogo.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity.this.finish();
            }
        }, 1000);
    }

}
