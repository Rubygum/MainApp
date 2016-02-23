package com.rubyko.mainapp.login.server.model;

/**
 * Created by alex on 23.02.16.
 */
public final class NoAuthedUser extends User {

    private final String mUserName;

    public NoAuthedUser(String mPassword, String pEmail, String mUserName) {
        super(mPassword, pEmail);
        this.mUserName = mUserName;
    }

    public String getUserName() {
        return mUserName;
    }

}
