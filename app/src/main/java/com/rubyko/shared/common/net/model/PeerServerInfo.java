package com.rubyko.shared.common.net.model;

import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public class PeerServerInfo implements Serializable {

    private Integer mPort;
    private String mIp;

    public void setPort(Integer pPort){
        this.mPort = pPort;
    }

    public  void setIp(String pIp){
        this.mIp = pIp;
    }

    public Integer getPort() {
        return mPort;
    }

    public String getIp() {
        return mIp;
    }
}
