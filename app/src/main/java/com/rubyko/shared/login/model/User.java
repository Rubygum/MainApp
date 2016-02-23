package com.rubyko.shared.login.model;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
 abstract class User implements Serializable {

    private final String mPassword;
    private final String mEmail;

    public User(String mPassword, String pEmail) {
        this.mPassword = mPassword;
        this.mEmail = pEmail;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getEmail() {
        return mEmail;
    }
}
