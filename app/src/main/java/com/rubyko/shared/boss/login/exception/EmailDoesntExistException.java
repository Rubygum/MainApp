package com.rubyko.shared.boss.login.exception;


/**
 * Created by alex on 23.02.16.
 */


import com.rubyko.rmi.RmiCheckedException;

/**
 * Throwed when the provided email doesn't exist.
 */
public class EmailDoesntExistException extends RmiCheckedException {

    public EmailDoesntExistException(Exception e) {
        super(e);
    }

    public EmailDoesntExistException(String string) {
        super(string);
    }
}
