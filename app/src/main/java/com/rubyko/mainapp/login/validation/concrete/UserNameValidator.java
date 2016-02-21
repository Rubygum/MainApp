package com.rubyko.mainapp.login.validation.concrete;

import android.widget.EditText;

import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 21.02.16.
 */
public class UserNameValidator extends LocalValidator {

    private final RubykoEditText mUserNameEdt;

    public UserNameValidator(RubykoEditText pUserNameEdt){
        this.mUserNameEdt = pUserNameEdt;
        mUserNameEdt.addValidator(this);
    }

    @Override
    public void update() {
        mUserNameEdt.update(false);
    }

    @Override
    public void svalidate() throws LocalValidatorException {
        final String userName = mUserNameEdt.getText().toString();

        if(userName.isEmpty()){
            throw new UserNameException("Please type your name");
        }
        if(userName.length() < MIN_USERNAME_LENGTH){
            throw new UserNameException("Your name must be more than " + MIN_USERNAME_LENGTH +" letters");
        }
    }


}
