package com.rubyko.shared.boss.net;

import com.rubyko.shared.NetInfo;
import com.rubyko.shared.PeerUpdateNetInfo;
import com.rubyko.shared.common.login.model.AccessCard;

/**
 * Created by alex on 06.03.16.
 */
public interface BossUpdateNetInfo<T> {

    void update(AccessCard accessCard, NetInfo netInfo, T t);

    void addListener(PeerUpdateNetInfo<T> peerUpdateNetInfo);

    void removeListener(PeerUpdateNetInfo<T> peerUpdateNetInfo);

}
