package com.rubyko.client.login.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.rubyko.client.login.validation.LocalValidator;
import com.rubyko.client.login.validation.concrete.EmailValidator;
import com.rubyko.client.login.validation.concrete.PasswordIdentityValidation;
import com.rubyko.client.login.validation.concrete.PasswordValidator;
import com.rubyko.client.login.validation.concrete.UserNameValidator;
import com.rubyko.client.login.view.RubykoEditText;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.rmi.RmiCheckedException;
import com.rubyko.shared.boss.login.LoginUserService;
import com.rubyko.shared.boss.login.RegisterUserService;
import com.rubyko.shared.common.login.model.User;

import java.io.IOException;
import java.io.Serializable;

public final class RegistrationFragment extends RubykoFragment<LoginRubykoActivity> implements View.OnClickListener {

    private LocalValidator<String, RubykoEditText> localValidator;

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        final View view = pInflater.inflate(R.layout.fragment_registration, pContainer, false);
        final RubykoEditText mUserNameEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_userName);
        final RubykoEditText mLoginEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_email);
        final RubykoEditText mPassEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_password);
        final RubykoEditText mRepassEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_repassword);

        localValidator = new UserNameValidator(mUserNameEdt).and(new EmailValidator(mLoginEdt));
        localValidator = localValidator.and(new PasswordValidator(mPassEdt));
        localValidator = localValidator.and(new PasswordIdentityValidation(mPassEdt, mRepassEdt));

        final Button regisrBtn = (Button) view.findViewById(R.id.registrDoneBtn);
        regisrBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public final void onClick(final View pView) {
        if(localValidator.isValid()) {
            final String userName = localValidator.getDataAll(R.id.editText_registr_userName);
            final String email = localValidator.getDataAll(R.id.editText_registr_email);
            final String pass = localValidator.getDataAll(R.id.editText_registr_password);
            final User user = new User(pass, email, null, null, userName);
            LoadingFragment.show(getFragmentActivity(), new RegisterRunnable(this, user));
        } else {
            localValidator.updateAll();
        }
    }
}

class RegisterRunnable implements Runnable, Serializable {

    private final User mUser;

    private final RegistrationFragment registrationFragment;

    public RegisterRunnable(RegistrationFragment registrationFragment, final User user) {
        this.mUser = user;
        this.registrationFragment = registrationFragment;
    }

    @Override
    public void run() {
        final RegisterUserService registerUserService = RubykoClient.lookupService(RegisterUserService.class, RegisterUserService.objectName1);
        try {
            final User user = registerUserService.register(mUser);
            Database.getDatabase().save(user, user.getClass().getName());
            registrationFragment.getFragmentActivity().runOnUiThread(new LoginSucessRunnable(user));
        } catch (final RmiCheckedException e) {
            registrationFragment.getFragmentActivity().runOnUiThread(new LoginExceptionTask(e));
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void hideLoadingFragment() {
        final FragmentManager fragmentManager = registrationFragment.getFragmentActivity().getSupportFragmentManager();
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
            Intent intent = new Intent(registrationFragment.getContext(), MainRubykoActivity.class);
            registrationFragment.startActivity(intent);
            registrationFragment.getFragmentActivity().finish();
        }
    }

    private class LoginExceptionTask implements Runnable {
        final RmiCheckedException rmiCheckedException;

        public LoginExceptionTask(RmiCheckedException rmiCheckedException) {
            this.rmiCheckedException = rmiCheckedException;
        }

        @Override
        public void run() {
            Toast.makeText(registrationFragment.getFragmentActivity(), rmiCheckedException.getMessage(), Toast.LENGTH_SHORT).show();
            hideLoadingFragment();
        }
    }

}


