package com.rubygum.mainapp;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yegor on 14/02/16.
 */
public abstract class BaseActivity extends FragmentActivity {

    protected final void addFragment(Bundle bundle, Class fragmentClass){
        try {
            BaseFragment fragment = (BaseFragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(getContainerId(), fragment, fragment.getTag());
            fragmentTransaction.commit();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    protected abstract  int getContainerId();

}
