package com.rubyko.shared.peer.chat;

import com.rubyko.shared.PeerUpdateNetInfo;
import com.rubyko.shared.common.login.model.AccessCard;
import com.rubyko.shared.common.chat.model.Message;
import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public interface ChatBox extends Serializable, PeerUpdateNetInfo<ChatBox> {

    void speak(Message message);
    void listen(Message message);

    void forget(Message message);
    void addListener(ChatBox user);
    void removeListener(ChatBox removeUser);

    AccessCard getPerson();
}
