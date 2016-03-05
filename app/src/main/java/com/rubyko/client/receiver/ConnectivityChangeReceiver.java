package com.rubyko.client.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.rubyko.RubykoApplication;
import com.rubyko.Utils;
import com.rubyko.client.common.database.Database;
import com.rubyko.shared.common.net.model.UserNetInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yegor on 29/02/16.
 */
public class ConnectivityChangeReceiver extends BroadcastReceiver {

    private List<UserNetInfoListener> userNetInfoListeners = new ArrayList<>();

    public void addListener(UserNetInfoListener userNetInfoListener){
        userNetInfoListeners.add(userNetInfoListener);
    }

    public void  removeListener(UserNetInfoListener userNetInfoListener){
        userNetInfoListeners.remove(userNetInfoListener);
    }

    private void update(UserNetInfo userNetInfo){
        for (UserNetInfoListener userNetInfoListener : userNetInfoListeners){
            userNetInfoListener.update(userNetInfo);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        debugIntent(intent, "grokkingandroid");

       // update(new UserNetInfo(Utils., Utils.getIPAddress(true)));
    }

    private void debugIntent(Intent intent, String tag) {
        Log.v(tag, "action: " + intent.getAction());
        Log.v(tag, "component: " + intent.getComponent());
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                Log.v(tag, "key [" + key + "]: " +
                        extras.get(key));
            }
        } else {
            Log.v(tag, "no extras");
        }
    }

}
