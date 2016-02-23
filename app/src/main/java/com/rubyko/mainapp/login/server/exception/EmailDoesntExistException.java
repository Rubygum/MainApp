package com.rubyko.mainapp.login.server.exception;


/**
 * Created by alex on 23.02.16.
 */

/**
 * Throwed when the provided email doesn't exist.
 */
public class EmailDoesntExistException extends Exception {

    public EmailDoesntExistException(Exception e) {
        super(e);
    }

    public EmailDoesntExistException(String string) {
        super(string);
    }
}
