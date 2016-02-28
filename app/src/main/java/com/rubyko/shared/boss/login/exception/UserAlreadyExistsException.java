package com.rubyko.shared.boss.login.exception;



/**
 * Created by alex on 23.02.16.
 */


import com.rubyko.rmi.RmiCheckedException;

/**
 * Throwed during registration when there's another user with such email.
 */
public final class UserAlreadyExistsException extends RmiCheckedException {

    public UserAlreadyExistsException(Exception e) {
        super(e);
    }

    public UserAlreadyExistsException(String string) {
        super(string);
    }
}
