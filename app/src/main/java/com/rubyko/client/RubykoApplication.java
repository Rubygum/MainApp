package com.rubyko.client;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by yegor on 14/02/16.
 */
public class RubykoApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private boolean isDestroyed = false;
    private boolean isStopped = false;
    private boolean isPaused = false;

    public RubykoApplication() {
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        isDestroyed = false;
    }

    @Override
    public void onActivityStarted(Activity activity) {
        isStopped = false;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        isPaused = false;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        isPaused = true;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        isStopped = true;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        isDestroyed = true;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public boolean isPaused() {
        return isPaused;
    }
}
