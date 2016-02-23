package com.rubyko.mainapp.login.validation.concrete;

import android.support.annotation.IdRes;

import com.rubyko.mainapp.login.validation.exception.KeyNotFoundException;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import com.rubyko.mainapp.login.validation.exception.PasswordException;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 21.02.16.
 */
public class PasswordValidator extends LocalValidator<String, RubykoEditText> {

    private final RubykoEditText mPasswordEdt;

    public PasswordValidator(RubykoEditText pPasswordEdt){
        this.mPasswordEdt = pPasswordEdt;
        mPasswordEdt.addValidator(this);
        vMap.put(mPasswordEdt.getId(), mPasswordEdt);
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

    protected String getData(@IdRes Integer pViewId) throws KeyNotFoundException {
        if(!vMap.containsKey(pViewId))
            throw new KeyNotFoundException();
        return vMap.get(pViewId).getText().toString();
    }

}


