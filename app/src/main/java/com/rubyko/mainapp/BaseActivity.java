package com.rubyko.mainapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yegor on 14/02/16.
 */
public abstract class BaseActivity extends FragmentActivity {

    public void replaceFragment(final Bundle bundle, final Class fragmentClass){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    BaseFragment fragment = (BaseFragment) fragmentClass.newInstance();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = BaseActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragment.getTag());
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                            android.R.anim.fade_in, android.R.anim.fade_out);
                    fragmentTransaction.replace(getContainerId(), fragment, fragment.getTag());
                    fragmentTransaction.commit();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void showFragment(final Bundle bundle, final Class fragmentClass){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    BaseFragment fragment = (BaseFragment) fragmentClass.newInstance();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = BaseActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragment.getTag());
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                            android.R.anim.fade_in, android.R.anim.fade_out);
                    fragment.show(fragmentTransaction, fragment.getTag());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    protected abstract int getContainerId();

}
