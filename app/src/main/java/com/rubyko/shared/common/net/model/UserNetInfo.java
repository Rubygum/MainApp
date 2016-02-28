package com.rubyko.shared.common.net.model;

import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public class UserNetInfo implements Serializable {

    private final Integer mPort;
    private final String mIp;

    public UserNetInfo(final Integer pPort, final String pIp){
        mPort = pPort;
        mIp = pIp;
    }

    public Integer getPort() {
        return mPort;
    }

    public String getIp() {
        return mIp;
    }
}
