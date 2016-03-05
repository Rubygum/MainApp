package com.rubyko.shared.peer.chat.implementation;

import com.rubyko.client.common.database.Database;
import com.rubyko.client.main.chat.adapter.ChatRecyclerViewAdapter;
import com.rubyko.shared.common.login.model.User;
import com.rubyko.shared.peer.chat.Conversation;
import com.rubyko.shared.common.chat.model.Message;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 28.02.16.
 */
public class ConversationImpl implements Conversation {

    private final User currentUser;
    private final List<Conversation> mChats = new ArrayList<>();
    private final List<Message> mMessages = new ArrayList<>();
    private final String chatRoomName;
    //private final ChatRecyclerViewAdapter mAdapter;

    public ConversationImpl(String chatRoomName) throws IOException, ClassNotFoundException {
        this.chatRoomName = chatRoomName;
        this.currentUser = Database.getDatabase().get(User.class.getName());
    }

    @Override
    public void send(Message message)  {
        for (Conversation conversation : mChats) {
            conversation.receive(message);
        }
    }

    @Override
    public void receive(Message message) {
        System.out.println(message.getMessage());
     //   mAdapter.addItem(message);
    }

    @Override
    public void delete(Message message) {

    }

    @Override
    public void addUser(User user, Conversation conversation) {
      //  mAuthedUsers.put(Integer.valueOf(user.getId()), conversation);
    }

    @Override
    public void removeUser(User user) {
      //  mAuthedUsers.remove(Integer.valueOf(user.getId()));
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

}
