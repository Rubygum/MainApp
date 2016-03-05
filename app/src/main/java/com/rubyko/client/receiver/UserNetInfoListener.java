package com.rubyko.client.receiver;

import com.rubyko.shared.common.net.model.UserNetInfo;

/**
 * Created by alex on 05.03.16.
 */
public interface UserNetInfoListener {

    void update(UserNetInfo userNetInfo);

}
