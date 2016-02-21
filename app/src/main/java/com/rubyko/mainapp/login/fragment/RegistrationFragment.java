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
import com.rubyko.mainapp.login.validation.concrete.PasswordIdentityValidation;
import com.rubyko.mainapp.login.validation.concrete.PasswordValidator;
import com.rubyko.mainapp.login.validation.concrete.UserNameValidator;
import com.rubyko.mainapp.login.view.RubykoEditText;

public final class RegistrationFragment extends BaseFragment<MainActivity> implements View.OnClickListener {

    private RubykoEditText mUserNameEdt;
    private RubykoEditText mLoginEdt;
    private RubykoEditText mPassEdt;
    private RubykoEditText mRepassEdt;

    private LocalValidator validator;

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        final View view = pInflater.inflate(R.layout.fragment_registration, pContainer, false);
        mUserNameEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_userName);
        mLoginEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_email);
        mPassEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_password);
        mRepassEdt = (RubykoEditText) view.findViewById(R.id.editText_registr_repassword);

        validator = new UserNameValidator(mUserNameEdt).and(new EmailValidator(mLoginEdt));
        validator = validator.and(new PasswordValidator(mPassEdt));
        validator = validator.and(new PasswordIdentityValidation(mPassEdt, mRepassEdt));

        final Button regisrBtn = (Button) view.findViewById(R.id.registrDoneBtn);
        regisrBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public final void onClick(final View pView) {
        if(validator.isValid()) {
            getFragmentActivity().showFragment(new Bundle(), LoadingFragment.class);
        } else {
            validator.updateAll();
        }
    }

}


