package com.rubyko.mainapp.login.validation.concrete;

import android.widget.EditText;

import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 21.02.16.
 */
public class PasswordValidator extends LocalValidator {

    private final RubykoEditText mPasswordEdt;

    public PasswordValidator(RubykoEditText pPasswordEdt){
        this.mPasswordEdt = pPasswordEdt;
        mPasswordEdt.addValidator(this);
    }

    @Override
    public void update() {
        mPasswordEdt.update(false);
    }

    @Override
    public void svalidate() throws LocalValidatorException {
        final String passwrod = mPasswordEdt.getText().toString();

        if (!passwrod.isEmpty() && passwrod.length() <= MIN_PASSWORD_LENGTH){
            throw new PasswordException("Your password must be more than " + MIN_PASSWORD_LENGTH + " letters");
        }
        if( passwrod.isEmpty()){
            throw new PasswordException("Please type your password");
        }
    }
}
