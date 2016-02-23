package com.rubyko.mainapp.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rubyko.mainapp.common.RubykoFragment;
import com.rubyko.mainapp.common.RubykoActivity;
import com.rubyko.mainapp.R;
import com.rubyko.mainapp.login.server.model.NoAuthedUser;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.concrete.EmailValidator;
import com.rubyko.mainapp.login.validation.concrete.PasswordValidator;
import com.rubyko.mainapp.login.view.RubykoEditText;


import java.io.Serializable;

/**
 * Created by alex on 16.02.16.
 */
public final class LoginFragment extends RubykoFragment<RubykoActivity> implements View.OnClickListener {

    private LocalValidator<String, RubykoEditText> localValidator;

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.fragment_login, pContainer, false);
        final Button loginDoneBtn = (Button) view.findViewById(R.id.loginDoneBtn);
        loginDoneBtn.setOnClickListener(this);

        final RubykoEditText emailEdt = (RubykoEditText) view.findViewById(R.id.editText_login_email);
        final RubykoEditText passEdt = (RubykoEditText) view.findViewById(R.id.editTextLogin_password);

        localValidator = new EmailValidator(emailEdt).and(new PasswordValidator(passEdt));
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginDoneBtn: {
                if(localValidator.isValid()) {
                    final String email = localValidator.getDataAll(R.id.editText_login_email);
                    final String pass = localValidator.getDataAll(R.id.editTextLogin_password);
                    final NoAuthedUser noAuthedUser = new NoAuthedUser(pass, email, null);
                    LoadingFragment.show(getFragmentActivity(), new LoginRunnable(noAuthedUser));
                } else {
                    localValidator.updateAll();
                }
            }
        }
    }

    private class LoginRunnable implements Runnable, Serializable {

        final NoAuthedUser noAuthedUser;

        public LoginRunnable(final NoAuthedUser noAuthedUser){
            this.noAuthedUser = noAuthedUser;
        }

        @Override
        public void run() {
          //  final LoginUserService loginUserService = RubykoClient.lookupService(LoginUserService.class, LoginUserService.objectName1);
          //  AuthedUser authedUser = loginUserService.login(noAuthedUser);
            // START MAIN FRAGMENY

        }

    }

}