package com.rubyko.client.main;

import android.os.Bundle;

import com.rubyko.client.R;
import com.rubyko.client.common.RubykoBaseActivity;
import com.rubyko.client.main.navigate.NavigateFragment;

/**
 * Created by alex on 27.02.16.
 */
public class MainRubykoActivity extends RubykoBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new Bundle(), NavigateFragment.class);
    }

    @Override
    protected int getContainerId() {
        return R.id.activityContainer;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else super.onBackPressed();
    }

}
