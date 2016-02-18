package com.rubyko.mainapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import fr.tvbarthel.lib.blurdialogfragment.BlurDialogEngine;

/**
 * Created by yegor on 18/02/16.
 */
public class BlurFragment<T extends BaseActivity> extends BaseFragment<T> {
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
    }

    @Override
    public void onResume() {
        super.onResume();
        mBlurEngine.onResume(getRetainInstance());
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mBlurEngine.onDismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBlurEngine.onDestroy();
    }

    @Override
    public void onDestroyView() {
        if (getDialog() != null) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

}
