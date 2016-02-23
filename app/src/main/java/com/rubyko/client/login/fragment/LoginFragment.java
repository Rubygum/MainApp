package com.rubyko.client.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rubyko.client.common.RubykoClient;
import com.rubyko.client.common.RubykoFragment;
import com.rubyko.client.common.RubykoActivity;
import com.rubyko.client.R;
import com.rubyko.shared.login.LoginUserService;
import com.rubyko.shared.login.model.AuthedUser;
import com.rubyko.shared.login.model.NoAuthedUser;
import com.rubyko.client.login.validation.LocalValidator;
import com.rubyko.client.login.validation.concrete.EmailValidator;
import com.rubyko.client.login.validation.concrete.PasswordValidator;
import com.rubyko.client.login.view.RubykoEditText;



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
            final LoginUserService loginUserService = RubykoClient.lookupService(LoginUserService.class, LoginUserService.objectName1);
            try {
                AuthedUser authedUser = loginUserService.login(noAuthedUser);
                System.out.println(authedUser);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}