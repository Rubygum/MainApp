package com.rubyko.client.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rubyko.client.common.RubykoClient;
import com.rubyko.client.common.RubykoFragment;
import com.rubyko.client.common.database.Database;
import com.rubyko.client.login.LoginRubykoActivity;
import com.rubyko.client.R;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.client.main.navigate.NavigateFragment;
import com.rubyko.rmi.RmiCheckedException;
import com.rubyko.shared.boss.login.LoginUserService;
import com.rubyko.client.login.validation.LocalValidator;
import com.rubyko.client.login.validation.concrete.EmailValidator;
import com.rubyko.client.login.validation.concrete.PasswordValidator;
import com.rubyko.client.login.view.RubykoEditText;
import com.rubyko.shared.common.login.model.User;


import java.io.IOException;
import java.io.Serializable;

/**
 * Created by alex on 16.02.16.
 */
public final class LoginFragment extends RubykoFragment<LoginRubykoActivity> implements View.OnClickListener {

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
        switch (v.getId()) {
            case R.id.loginDoneBtn: {
                if (localValidator.isValid()) {
                    final String email = localValidator.getDataAll(R.id.editText_login_email);
                    final String pass = localValidator.getDataAll(R.id.editTextLogin_password);
                    final User noUser = new User(pass, email, null, null, null);
                    LoadingFragment.show(getFragmentActivity(), new LoginRunnable(this, noUser));
                } else {
                    localValidator.updateAll();
                }
            }
        }
    }
}

class LoginRunnable implements Runnable, Serializable {

    private final User noUser;

    private final LoginFragment loginFragment;

    public LoginRunnable(LoginFragment loginFragment, final User noUser) {
        this.noUser = noUser;
        this.loginFragment = loginFragment;
    }

    @Override
    public void run() {
        final LoginUserService loginUserService = RubykoClient.lookupService(LoginUserService.class, LoginUserService.objectName1);
        try {
            final User user = loginUserService.login(noUser);
            Database.getDatabase().save(user, user.getClass().getName());
            loginFragment.getFragmentActivity().runOnUiThread(new LoginSucessRunnable(user));
        } catch (final RmiCheckedException e) {
            loginFragment.getFragmentActivity().runOnUiThread(new LoginExceptionTask(e));
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void hideLoadingFragment() {
        final FragmentManager fragmentManager = loginFragment.getFragmentActivity().getSupportFragmentManager();
        fragmentManager.popBackStackImmediate();
    }

    private class LoginSucessRunnable implements Runnable {
        private final User user;

        public LoginSucessRunnable(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            hideLoadingFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(LoadingFragment.TASK, user);
            Intent intent = new Intent(loginFragment.getContext(), MainRubykoActivity.class);
            loginFragment.startActivity(intent);
            loginFragment.getFragmentActivity().finish();
        }
    }

    private class LoginExceptionTask implements Runnable {
        final RmiCheckedException rmiCheckedException;

        public LoginExceptionTask(RmiCheckedException rmiCheckedException) {
            this.rmiCheckedException = rmiCheckedException;
        }

        @Override
        public void run() {
            Toast.makeText(loginFragment.getFragmentActivity(), rmiCheckedException.getMessage(), Toast.LENGTH_SHORT).show();
            hideLoadingFragment();
        }
    }
}