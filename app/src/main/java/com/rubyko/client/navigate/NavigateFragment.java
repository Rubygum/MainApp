package com.rubyko.client.navigate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rubyko.client.R;
import com.rubyko.client.common.RubykoActivity;
import com.rubyko.client.common.RubykoFragment;


/**
 * Created by alex on 24.02.16.
 */
public class NavigateFragment extends RubykoFragment<RubykoActivity> {



    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_navigate, pContainer, false);
        return view;
    }

    @Override
    public int getPosition() {
        return 2;
    }
}
