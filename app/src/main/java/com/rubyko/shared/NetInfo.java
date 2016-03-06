package com.rubyko.shared;

/**
 * Created by alex on 06.03.16.
 */
public class NetInfo {

    private String IP;
    private Integer port;

    public NetInfo(String IP, Integer port) {
        this.IP = IP;
        this.port = port;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
