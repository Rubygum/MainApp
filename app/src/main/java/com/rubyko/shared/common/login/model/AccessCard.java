package com.rubyko.shared.common.login.model;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public final class AccessCard implements Serializable {

    private final String mPassword;
    private final String mEmail;

    private final String mId;
    private final String mToken;
    private final String mUserName;

   // private PeerServerInfo peerServerInfo = RubykoServer.getPeerServerInfo();

    public AccessCard(String mPassword, String pEmail) {
        this.mPassword = mPassword;
        this.mEmail = pEmail;
        this.mId = null;
        this.mToken = null;
        this.mUserName = null;
    }

    public AccessCard(String mPassword, String pEmail, String mId, String mToken, String mUserName) {
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


    public String getEmail(){
        return mEmail;
    }

    public String getPassword(){
        return mPassword;
    }



    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
     //   stream.defaultReadObject();
       // this.peerServerInfo = RubykoServer.getPeerServerInfo();
    }


}
