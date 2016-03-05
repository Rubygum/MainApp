package com.rubyko.server;

import com.rubyko.rmi.RmiServer;
import com.rubyko.shared.common.net.model.PeerServerInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 05.03.16.
 */
public class RubykoServer {

    private static final RubykoServer rubykoServer = new RubykoServer();

    private final RmiServer rmiServer;
    private final PeerServerInfo peerServerInfo = new PeerServerInfo();

    private RubykoServer() {
        // peek up the right port number
        int portNumber = findFreePort();
        String ip = getIPAddress(false);

        // create rmi server
        rmiServer = new RmiServer(portNumber);

        // update network info
        peerServerInfo.setIp(ip);
        peerServerInfo.setPort(portNumber);
    }


    public static void updateIp(){
        final String ip = rubykoServer.getIPAddress(true);
        rubykoServer.peerServerInfo.setIp(ip);
    }

    public static void registerService(String serviceName, Object serviceImpl){
        rubykoServer.rmiServer.registerService(serviceName, serviceImpl);
    }


    public static PeerServerInfo getPeerServerInfo() {
        return rubykoServer.peerServerInfo;
    }

    private int findFreePort() {
        try {
            ServerSocket s = new ServerSocket(0);
            s.close();
            return s.getLocalPort();
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
    }


    /**
     * Get IP address from first non-localhost interface
     *
     * @param ipv4 true=return ipv4, false=return ipv6
     * @return address or empty string
     */
    private String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        boolean isIPv4 = sAddr.indexOf(':') < 0;

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                return delim < 0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
        } // for now eat exceptions
        return "";
    }


    public static void start(){
        rubykoServer.rmiServer.start();
    }


    public static void stop(){
        rubykoServer.rmiServer.stop();
    }


}
