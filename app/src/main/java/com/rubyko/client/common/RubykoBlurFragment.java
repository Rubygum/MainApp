package com.rubyko.client.common;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import fr.tvbarthel.lib.blurdialogfragment.BlurDialogEngine;

/**
 * Created by yegor on 18/02/16.
 */
public abstract class RubykoBlurFragment<T extends RubykoBaseActivity> extends RubykoFragment<T> {
/*
    /**
     * Engine used to blur.
     */
    private BlurDialogEngine mBlurEngine;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBlurEngine = new BlurDialogEngine(getFragmentActivity());
        mBlurEngine.debug(false);
        mBlurEngine.setBlurRadius(8);
        mBlurEngine.setDownScaleFactor(8f);
        mBlurEngine.setBlurActionBar(true);
        mBlurEngine.setUseRenderScript(true);
        this.setRetainInstance(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBlurEngine.onResume(getRetainInstance());
        Log.w("loading", "onResume");
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mBlurEngine.onDismiss();
        Log.w("loading", "onDismiss");
    }

    @Override
    public void onDestroy() {
        mBlurEngine.onDismiss();
        super.onDestroy();
        mBlurEngine.onDestroy();
        Log.w("loading", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        if (getDialog() != null) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

}
