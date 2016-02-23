package com.rubyko.client.login.validation.exception;

import com.rubyko.client.login.validation.LocalValidatorException;

/**
 * Created by alex on 23.02.16.
 */
public class UserNameException extends LocalValidatorException {
    public UserNameException(String pDetailMessage){
        super(pDetailMessage);
    }
}
