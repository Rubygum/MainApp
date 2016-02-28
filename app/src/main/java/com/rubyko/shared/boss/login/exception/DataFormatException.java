package com.rubyko.shared.boss.login.exception;


/**
 * Created by alex on 23.02.16.
 */


import com.rubyko.rmi.RmiCheckedException;


/**
 * Throwed when the data consists of unacceptable symbols.
 */
public class DataFormatException extends RmiCheckedException {

    public DataFormatException(Exception e) {
        super(e);
    }

    public DataFormatException(String string) {
        super(string);
    }

}
