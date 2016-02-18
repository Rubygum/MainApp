package com.rubyko.mainapp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.rubyko.mainapp.BaseFragment;
import com.rubyko.mainapp.R;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;

public final class RegistrationFragment extends BaseFragment<LoginActivity> implements View.OnClickListener {

    private EditText mUserNameEdt;
    private EditText mLoginEdt;
    private EditText mPassEdt;
    private EditText mRepassEdt;

    private final LocalValidator mLocalValidator = new LocalValidator();

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        final View view = pInflater.inflate(R.layout.fragment_registration, pContainer, false);
        mUserNameEdt = (EditText) view.findViewById(R.id.userName);
        mLoginEdt = (EditText) view.findViewById(R.id.login);
        mPassEdt = (EditText) view.findViewById(R.id.password);
        mRepassEdt = (EditText) view.findViewById(R.id.repassword);

        final Button regisrBtn = (Button) view.findViewById(R.id.regisrBtn);
        regisrBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public final void onClick(final View pView) {
        try {
            mLocalValidator.checkUserName(mUserNameEdt.getText().toString());
            mLocalValidator.checkLogin(mLoginEdt.getText().toString());
            mLocalValidator.checkPasswords(mPassEdt.getText().toString(), mRepassEdt.getText().toString());
        } catch (final LocalValidatorException e){
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}