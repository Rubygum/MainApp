package com.rubyko.shared.common.login.model;

import com.rubyko.server.RubykoServer;
import com.rubyko.shared.boss.net.BossUserNetInfoUpdater;
import com.rubyko.shared.common.net.model.PeerServerInfo;
import com.rubyko.shared.peer.net.PeerUserNetInfoUpdater;

import java.io.IOException;
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

    private PeerServerInfo peerServerInfo = RubykoServer.getPeerServerInfo();
    private boolean online = false;

    public User(String mPassword, String pEmail) {
        this.mPassword = mPassword;
        this.mEmail = pEmail;
        this.mId = null;
        this.mToken = null;
        this.mUserName = null;
    }

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

    public PeerServerInfo getPeerServerInfo() {
        return peerServerInfo;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }


    public String getEmail(){
        return mEmail;
    }

    public String getPassword(){
        return mPassword;
    }

    @Override
    public void update(PeerServerInfo peerServerInfo) {
        // from outer clients
        this.peerServerInfo.setIp(peerServerInfo.getIp());
        this.peerServerInfo.setPort(peerServerInfo.getPort());
    }


    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.peerServerInfo = RubykoServer.getPeerServerInfo();
    }

    @Override
    public String toString() {
        return "User [mPassword=" + mPassword + ", mEmail=" + mEmail + ", mId=" + mId + ", mToken=" + mToken
                + ", mUserName=" + mUserName + ", peerServerInfo=" + peerServerInfo + ", online=" + online + "]";
    }


}
