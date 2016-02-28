package com.rubyko.shared.peer.chat;

import com.rubyko.shared.common.login.model.User;
import com.rubyko.shared.common.chat.model.Message;
import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public interface Conversation extends Serializable {

    void send(Message message);
    void receive(Message message);


    void delete(Message message);
    void addUser(User user, Conversation conversation);
    void removeUser(User removeUser);

    User getCurrentUser();
}
