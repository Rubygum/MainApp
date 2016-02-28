package com.rubyko.shared.common.login.model;

import com.rubyko.shared.boss.net.BossUserNetInfoUpdater;
import com.rubyko.shared.common.net.model.UserNetInfo;
import com.rubyko.shared.peer.net.PeerUserNetInfoUpdater;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public final class User implements Serializable, PeerUserNetInfoUpdater, BossUserNetInfoUpdater {

    private final String mPassword;
    private final String mEmail;

    private final String mId;
    private final String mToken;
    private final String mUserName;

    private UserNetInfo userNetInfo;
    private boolean online;

    public User(String mPassword, String pEmail, String mId, String mToken, String mUserName) {
        this.mPassword = mPassword;
        this.mEmail = pEmail;
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

    @Override
    public void update(UserNetInfo userNetInfo) {
        this.userNetInfo = userNetInfo;
    }

    public UserNetInfo getUserNetInfo() {
        return userNetInfo;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
