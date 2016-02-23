package com.rubyko.mainapp.common;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;

/**
 * Created by yegor on 14/02/16.
 */
public abstract class RubykoBaseActivity extends FragmentActivity {

    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    public void replaceFragment(final Bundle bundle, final Class fragmentClass){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    RubykoFragment fragment = (RubykoFragment) fragmentClass.newInstance();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = RubykoBaseActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragmentClass.getName());
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                            android.R.anim.fade_in, android.R.anim.fade_out);
                    fragmentTransaction.replace(getContainerId(), fragment, fragmentClass.getName());
                    fragmentTransaction.commit();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public <T extends Fragment> void showFragment(final Bundle bundle, final Class<T> fragmentClass){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    RubykoFragment fragment = (RubykoFragment) fragmentClass.newInstance();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = RubykoBaseActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragmentClass.getName());
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                            android.R.anim.fade_in, android.R.anim.fade_out);
                    fragment.show(fragmentTransaction, fragmentClass.getName());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    protected abstract int getContainerId();

}
