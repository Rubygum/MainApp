package com.rubyko.client.login.validation.concrete;

import android.support.annotation.IdRes;

import com.rubyko.client.login.validation.exception.KeyNotFoundException;
import com.rubyko.client.login.validation.LocalValidator;
import com.rubyko.client.login.validation.LocalValidatorException;
import com.rubyko.client.login.validation.exception.UserNameException;
import com.rubyko.client.login.view.RubykoEditText;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by alex on 21.02.16.
 */
public class UserNameValidator extends LocalValidator<String, RubykoEditText> {

    private final RubykoEditText mUserNameEdt;

    public UserNameValidator(RubykoEditText pUserNameEdt){
        this.mUserNameEdt = pUserNameEdt;
        mUserNameEdt.addValidator(this);
        vMap.put(mUserNameEdt.getId(), mUserNameEdt);
    }

    @Override
    protected void update() {
        mUserNameEdt.update(false);
    }

    @Override
    protected void svalidate() throws LocalValidatorException {
        final String userName = mUserNameEdt.getText().toString();

        if(userName.isEmpty()){
            throw new UserNameException("Please type your name");
        }
        if(!StringUtils.isAlphanumeric(userName)){
            throw new UserNameException("Only strings and numbers are permissible");
        }
        if(userName.length() < MIN_USERNAME_LENGTH){
            throw new UserNameException("Your name must be more than " + MIN_USERNAME_LENGTH +" letters");
        }
    }

    @Override
    protected String getData(@IdRes Integer pViewId) throws KeyNotFoundException {
        if(!vMap.containsKey(pViewId))
            throw new KeyNotFoundException();
        return vMap.get(pViewId).getText().toString();
    }

}
