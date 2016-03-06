package com.rubyko.client.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.rubyko.server.RubykoServer;

/**
 * Created by yegor on 29/02/16.
 */
public class ConnectivityChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        RubykoServer.getInstance().updateIp();
    }

}
