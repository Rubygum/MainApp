package com.rubyko.mainapp.login.validation.concrete;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 21.02.16.
 */
public class PasswordIdentityValidation extends LocalValidator {

    private final RubykoEditText mPasswordEdt;
    private final RubykoEditText mRePasswordEdt;

    public PasswordIdentityValidation(RubykoEditText pPasswordEdt, RubykoEditText pRePasswordEdt){
        this.mPasswordEdt = pPasswordEdt;
        this.mRePasswordEdt = pRePasswordEdt;
        mPasswordEdt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                mRePasswordEdt.update(true);
                return false;
            }
        });
        mRePasswordEdt.addValidator(this);
    }


    @Override
    public void update() {
        mRePasswordEdt.update(false);
    }

    @Override
    public void svalidate() throws LocalValidatorException {
        final String password = mPasswordEdt.getText().toString();
        final String repassword = mRePasswordEdt.getText().toString();
        if(repassword.isEmpty()){
            throw new PasswordException("Please repeat your password");
        }
        if (!repassword.isEmpty() && repassword.length() <= MIN_PASSWORD_LENGTH){
            throw new PasswordException("Your password must be more than " + MIN_PASSWORD_LENGTH + " letters");
        }
        if(!password.equals(repassword)){
            throw new PasswordException("Your passwords don't match");
        }

    }

}
