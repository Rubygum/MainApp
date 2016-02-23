package com.rubyko.client.common;


import com.rubyko.rmi.RmiClient;

/**
 * Created by alex on 23.02.16.
 */
public class RubykoClient {

    private static final int PORT = 6789;
    private static final String ENDPOINT = "192.168.9.77";

    public static <T> T lookupService(Class<T> clazz, String name){
        return RmiClient.lookupService(ENDPOINT, PORT, name, clazz);
    }

}
