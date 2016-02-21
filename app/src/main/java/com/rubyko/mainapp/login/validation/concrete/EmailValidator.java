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
        final String email = mEmailEdt.getText().toString();
        if(email.isEmpty()){
            throw new EmailException("Please type your email");
        }
        if(!org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email)){
            throw new EmailException("Your email format is incorrect");
        }
    }
}
