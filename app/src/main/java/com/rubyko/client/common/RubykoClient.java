package com.rubyko.client.common;


import com.rubyko.rmi.RmiClient;
import com.rubyko.shared.common.login.model.User;
import com.rubyko.shared.common.net.model.UserNetInfo;

/**
 * Created by alex on 23.02.16.
 */
public class RubykoClient {


    // boss
    private static final int PORT = 6789;
    private static final String ENDPOINT = "192.168.9.77";

    public static <T> T lookupService(Class<T> clazz, String name){
        return RmiClient.lookupService(ENDPOINT, PORT, name, clazz);
    }

    // peer
    public static <T> T lookupService(User user, Class<T> clazz, String name){
        UserNetInfo userNetInfo = user.getUserNetInfo();
        return RmiClient.lookupService(userNetInfo.getIp(), userNetInfo.getPort(), name, clazz);
    }

}
