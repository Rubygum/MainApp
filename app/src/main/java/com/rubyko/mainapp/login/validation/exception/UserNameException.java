package com.rubyko.mainapp.login.validation.exception;

import com.rubyko.mainapp.login.validation.LocalValidatorException;

/**
 * Created by alex on 23.02.16.
 */
public class UserNameException extends LocalValidatorException {
    public UserNameException(String pDetailMessage){
        super(pDetailMessage);
    }
}
