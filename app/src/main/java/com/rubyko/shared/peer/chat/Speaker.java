package com.rubyko.shared.peer.chat;

import com.rubyko.shared.common.login.model.User;
import com.rubyko.shared.common.chat.model.Message;
import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public interface Speaker extends Serializable {

    void speak(Message message);
    void listen(Message message);

    void forget(Message message);
    void addListener(Speaker user);
    void removeListener(Speaker removeUser);

    User getPerson();
}
