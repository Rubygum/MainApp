package com.rubyko.mainapp;

import android.support.v4.app.Fragment;

/**
 * Created by yegor on 14/02/16.
 */
public class BaseFragment<T extends BaseActivity> extends Fragment {

    public final T getFragmentActivity(){
        return (T) getActivity();
    }

}
// LayoutInflater inflater = LayoutInflater.from(getFragmentActivity());