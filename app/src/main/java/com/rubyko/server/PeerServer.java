package com.rubyko.server;

import com.rubyko.rmi.RmiServer;

/**
 * Created by alex on 05.03.16.
 */
public class PeerServer {

    private static final int PORT = 6789;
    private static final RmiServer rpcServer = new RmiServer(PORT);

    private PeerServer() {
    }

    public static RmiServer getInstance(){
        return rpcServer;
    }

}
