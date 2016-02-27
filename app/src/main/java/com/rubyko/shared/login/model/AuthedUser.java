package com.rubyko.shared.login.model;

/**
 * Created by alex on 23.02.16.
 */
public final class AuthedUser extends User {

    private final String mId;
    private final String mToken;
    private final String mUserName;

    public AuthedUser(String mPassword, String pEmail, String mId, String mToken, String mUserName) {
        super(mPassword, pEmail);
        this.mId = mId;
        this.mToken = mToken;
        this.mUserName = mUserName;
    }

    public boolean isTokenValid(){
        return true;
    }

    public String getId() {
        return mId;
    }

    public String getToken() {
        return mToken;
    }

    public String getUserName() {
        return mUserName;
    }
}
