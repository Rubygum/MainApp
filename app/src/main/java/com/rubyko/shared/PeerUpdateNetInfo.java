package com.rubyko.shared;

import java.util.List;

/**
 * Created by alex on 06.03.16.
 */
public interface PeerUpdateNetInfo<T> {

    void update(T t, NetInfo netInfo);

}
