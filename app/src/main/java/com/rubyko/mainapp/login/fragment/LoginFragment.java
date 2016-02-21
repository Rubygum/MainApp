package com.rubyko.mainapp.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rubyko.mainapp.BaseFragment;
import com.rubyko.mainapp.MainActivity;
import com.rubyko.mainapp.R;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.concrete.EmailValidator;
import com.rubyko.mainapp.login.validation.concrete.PasswordValidator;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 16.02.16.
 */
public final class LoginFragment extends BaseFragment<MainActivity> implements View.OnClickListener{

    private RubykoEditText mEmailEdt, mPassEdt;
    private LocalValidator localValidator;

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_login, pContainer, false);
        final Button loginDoneBtn = (Button) view.findViewById(R.id.loginDoneBtn);
        loginDoneBtn.setOnClickListener(this);

        mEmailEdt = (RubykoEditText) view.findViewById(R.id.editText_login_email);
        mPassEdt = (RubykoEditText) view.findViewById(R.id.editTextLogin_password);

        localValidator = new EmailValidator(mEmailEdt).and(new PasswordValidator(mPassEdt));
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginDoneBtn: {
                if(localValidator.isValid()) {
                    getFragmentActivity().showFragment(new Bundle(), LoadingFragment.class);
                } else {
                    localValidator.updateAll();
                }
            }
        }
    }

}