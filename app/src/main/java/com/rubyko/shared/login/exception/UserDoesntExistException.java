package com.rubyko.shared.login.exception;



/**
 * Created by alex on 23.02.16.
 */


import com.rubyko.rmi.RmiCheckedException;


/**
 * Throwed when the user attempts to use wrong data during the login operation.
 */
public final class UserDoesntExistException extends RmiCheckedException {

    public UserDoesntExistException(Exception e) {
        super(e);
    }

    public UserDoesntExistException(String string) {
        super(string);
    }
}
