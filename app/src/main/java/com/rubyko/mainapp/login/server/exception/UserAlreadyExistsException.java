package com.rubyko.mainapp.login.server.exception;



/**
 * Created by alex on 23.02.16.
 */

/**
 * Throwed during registration when there's another user with such email.
 */
public final class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(Exception e) {
        super(e);
    }

    public UserAlreadyExistsException(String string) {
        super(string);
    }
}
