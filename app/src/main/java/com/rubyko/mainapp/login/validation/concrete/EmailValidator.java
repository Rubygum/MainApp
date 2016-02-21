package com.rubyko.mainapp.login.validation.concrete;

import android.widget.EditText;

import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 21.02.16.
 */
public class EmailValidator extends LocalValidator {

    private final RubykoEditText mEmailEdt;

    public EmailValidator(RubykoEditText pEmailEdt){
        this.mEmailEdt = pEmailEdt;
        mEmailEdt.addValidator(this);
    }

    @Override
    public void update() {
        mEmailEdt.update(false);
    }

    @Override
    public void svalidate() throws LocalValidatorException {
        final String login = mEmailEdt.getText().toString();
        if(login.isEmpty()){
            throw new LoginException("Please type your email");
        }
        if(login.length() < MIN_LOGIN_LENGTH){
            throw new LoginException("Your email must be more than " + MIN_LOGIN_LENGTH +" letters");
        }
    }
}
