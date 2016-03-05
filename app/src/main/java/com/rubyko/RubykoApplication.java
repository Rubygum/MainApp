package com.rubyko;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.rubyko.client.receiver.ConnectivityChangeReceiver;
import com.rubyko.client.receiver.PeerNetInfoListener;

/**
 * Created by yegor on 14/02/16.
 */
public class RubykoApplication extends Application  {

    private static RubykoApplication instance;

    {
        instance = this;
    }

    public static RubykoApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        final ConnectivityChangeReceiver connectivityChangeReceiver = new ConnectivityChangeReceiver();
        registerReceiver(connectivityChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

//        ConnectivityManager connManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo info = connManager.getActiveNetworkInfo();
    }



}
