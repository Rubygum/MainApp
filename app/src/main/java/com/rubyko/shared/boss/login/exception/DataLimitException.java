package com.rubyko.shared.boss.login.exception;



/**
 * Created by alex on 23.02.16.
 */


import com.rubyko.rmi.RmiCheckedException;

/**
 * Throwed when the length of data is out of acceptable bounds.
 */
public class DataLimitException extends RmiCheckedException {

    public DataLimitException(Exception e) {
        super(e);
    }

    public DataLimitException(String string) {
        super(string);
    }

}
