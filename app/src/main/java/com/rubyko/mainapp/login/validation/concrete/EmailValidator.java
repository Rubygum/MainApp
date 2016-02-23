package com.rubyko.mainapp.login.validation.concrete;

import android.support.annotation.IdRes;

import com.rubyko.mainapp.login.validation.exception.KeyNotFoundException;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import com.rubyko.mainapp.login.validation.exception.EmailException;
import com.rubyko.mainapp.login.view.RubykoEditText;

/**
 * Created by alex on 21.02.16.
 */
public class EmailValidator extends LocalValidator<String, RubykoEditText> {

    private final RubykoEditText mEmailEdt;

    public EmailValidator(RubykoEditText pEmailEdt){
        this.mEmailEdt = pEmailEdt;
        mEmailEdt.addValidator(this);
        vMap.put(mEmailEdt.getId(), mEmailEdt);
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

    @Override
    protected String getData(@IdRes Integer pViewId) throws KeyNotFoundException {
        if(!vMap.containsKey(pViewId))
            throw new KeyNotFoundException();
        return vMap.get(pViewId).getText().toString();
    }

}
