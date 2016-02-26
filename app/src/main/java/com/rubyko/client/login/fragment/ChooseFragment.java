package com.rubyko.client.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rubyko.client.common.RubykoFragment;
import com.rubyko.client.common.RubykoActivity;
import com.rubyko.client.R;


/**
 * Created by yegor on 14/02/16.
 */
public final class ChooseFragment extends RubykoFragment<RubykoActivity> implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_choose, container, false);
        final Button loginBtn = (Button) view.findViewById(R.id.loginBtn);
        final Button registrBtn = (Button) view.findViewById(R.id.regisrBtn);
        loginBtn.setOnClickListener(this);
        registrBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                getFragmentActivity().replaceFragment(new Bundle(), LoginFragment.class, 1);
                break;
            case R.id.regisrBtn:
                getFragmentActivity().replaceFragment(new Bundle(), RegistrationFragment.class, 1);
                break;
        }
    }

    @Override
    public int getPosition() {
        return 0;
    }
}
