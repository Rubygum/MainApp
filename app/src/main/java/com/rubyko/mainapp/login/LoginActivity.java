package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.rubyko.mainapp.BaseActivity;
import com.rubyko.mainapp.BaseFragment;
import com.rubyko.mainapp.R;
import com.rubyko.mainapp.login.adapter.SmartFragmentStatePagerAdapter;
import com.rubyko.mainapp.login.view.ParallaxViewPager;

import java.util.ArrayList;

import tyrantgit.explosionfield.ExplosionField;


/**
 * Created by yegor on 14/02/16.
 */
public class LoginActivity extends BaseActivity implements FragmentManager.OnBackStackChangedListener {

    private ExplosionField explosionField;
    private ImageView mLogo;
    private ParallaxViewPager vpPager;
    private MyPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        explosionField = ExplosionField.attach2Window(this);
        mLogo = (ImageView) findViewById(R.id.logo);

        vpPager = (ParallaxViewPager) findViewById(R.id.vpPager);
        vpPager.setBackgroundResource(R.drawable.bkg3);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        adapterViewPager.addFragment(new ChooseFragment(), vpPager);
        vpPager.setAdapter(adapterViewPager);

        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    @Override
    protected int getContainerId() {
        return R.id.activityContainer;
    }

    public void explode(View view) {
        explosionField.explode(view);
    }


    public final void replaceFragment(final Bundle bundle, final Class fragmentClass) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    adapterViewPager.clearFragments();
                    BaseFragment fragment = (BaseFragment) fragmentClass.newInstance();
                    adapterViewPager.addFragment(fragment, vpPager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (vpPager.getCurrentItem() != 0) {
            vpPager.setCurrentItem(vpPager.getCurrentItem() - 1, true);
        } else super.onBackPressed();
    }


    @Override
    public void onBackStackChanged() {
     /*   if(getSupportFragmentManager().getBackStackEntryCount() != 1){
            hideLogo();
        }
        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
            showLogo();
            destroy();
        }*/
    }


    // Extend from SmartFragmentStatePagerAdapter now instead for more dynamic ViewPager items
    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter {

        private ArrayList<Fragment> arrFragment = new ArrayList<android.support.v4.app.Fragment>();


        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public ArrayList<android.support.v4.app.Fragment> getFragments() {
            return arrFragment;
        }

        public void clearFragments() {
            Fragment frag = arrFragment.get(0);
            arrFragment.clear();
            arrFragment.add(frag);
        }


        public void addFragment(BaseFragment frag, ViewPager vpPager) {
          //  vpPager.setCurrentItem(0);
            arrFragment.add(frag);
            this.notifyDataSetChanged();
            vpPager.setCurrentItem(this.getCount() - 1);
        }


        // Returns total number of pages
        @Override
        public int getCount() {
            return arrFragment.size();
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return arrFragment.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
