package com.rubyko.mainapp.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.rubyko.mainapp.common.RubykoFragment;
import com.rubyko.mainapp.common.RubykoActivity;
import com.rubyko.mainapp.R;
import com.rubyko.mainapp.login.server.model.NoAuthedUser;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.concrete.EmailValidator;
import com.rubyko.mainapp.login.validation.concrete.PasswordIdentityValidation;
import com.rubyko.mainapp.login.validation.concrete.PasswordValidator;
import com.rubyko.mainapp.login.validation.concrete.UserNameValidator;
import com.rubyko.mainapp.login.view.RubykoEditText;

import java.io.Serializable;

public final class RegistrationFragment extends RubykoFragment<RubykoActivity> implements View.OnClickListener {



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

            final NoAuthedUser noAuthedUser = new NoAuthedUser(pass, email, userName);
            LoadingFragment.show(getFragmentActivity(), new RegisterRunnable(noAuthedUser));
        } else {
            localValidator.updateAll();
        }
    }

    private class RegisterRunnable implements Runnable, Serializable {

        private final NoAuthedUser noAuthedUser;

        private Context context =  RegistrationFragment.this.getActivity().getApplicationContext();

        public RegisterRunnable(final NoAuthedUser noAuthedUser){
            this.noAuthedUser = noAuthedUser;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(2_000);
                } catch (Exception e){}

                new Handler(context.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "REISTRATION", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            //   final RegisterUserService loginUserService = RubykoClient.lookupService(RegisterUserService.class, RegisterUserService.objectName1);
         //   AuthedUser authedUser = loginUserService.register(noAuthedUser);
            // START MAIN FRAGMENY
        }

    }

}


