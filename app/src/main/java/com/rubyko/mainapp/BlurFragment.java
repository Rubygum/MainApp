package com.rubyko.mainapp;

import android.os.Bundle;

import fr.tvbarthel.lib.blurdialogfragment.BlurDialogEngine;

/**
 * Created by yegor on 18/02/16.
 */
public class BlurFragment<T extends  BaseActivity> extends BaseFragment<T> {

    /**
     * Engine used to blur.
     */
    private BlurDialogEngine mBlurEngine;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBlurEngine = new BlurDialogEngine(getActivity());
        mBlurEngine.setBlurRadius(8);
        mBlurEngine.setDownScaleFactor(8f);
        mBlurEngine.debug(false);
        mBlurEngine.setBlurActionBar(true);
        mBlurEngine.setUseRenderScript(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBlurEngine.onResume(getRetainInstance());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mBlurEngine.onDestroy();
    }

}
