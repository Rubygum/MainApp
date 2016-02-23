package com.rubyko.mainapp.login.server.exception;



/**
 * Created by alex on 23.02.16.
 */

/**
 * Throwed when the length of data is out of acceptable bounds.
 */
public class DataLimitException extends Exception {

    public DataLimitException(Exception e) {
        super(e);
    }

    public DataLimitException(String string) {
        super(string);
    }

}
