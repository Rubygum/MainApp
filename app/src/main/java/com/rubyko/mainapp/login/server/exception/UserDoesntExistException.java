package com.rubyko.mainapp.login.server.exception;



/**
 * Created by alex on 23.02.16.
 */

/**
 * Throwed when the user attempts to use wrong data during the login operation.
 */
public final class UserDoesntExistException extends Exception {

    public UserDoesntExistException(Exception e) {
        super(e);
    }

    public UserDoesntExistException(String string) {
        super(string);
    }
}
