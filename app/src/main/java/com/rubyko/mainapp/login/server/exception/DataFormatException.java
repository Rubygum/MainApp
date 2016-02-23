package com.rubyko.mainapp.login.server.exception;



/**
 * Created by alex on 23.02.16.
 */

/**
 * Throwed when the data consists of unacceptable symbols.
 */
public class DataFormatException extends Exception {

    public DataFormatException(Exception e) {
        super(e);
    }

    public DataFormatException(String string) {
        super(string);
    }

}
