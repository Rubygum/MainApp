package com.rubyko.shared.peer.chat.implementation;

import com.rubyko.client.common.database.Database;
import com.rubyko.shared.common.login.model.User;
import com.rubyko.shared.peer.chat.Speaker;
import com.rubyko.shared.common.chat.model.Message;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 28.02.16.
 */
public class SpeakerImpl implements Speaker {

    private final User currentUser;

    private final List<Speaker> mSpeakers = new ArrayList<>();
    private final List<Message> mMessages = new ArrayList<>();
    private final String conversationName;

    public SpeakerImpl(String conversationName) throws IOException, ClassNotFoundException {
        this.conversationName = conversationName;
        this.currentUser = Database.getDatabase().get(User.class.getName());
        this.mSpeakers.add(this);
    }

    @Override
    public void speak(Message message)  {
        for (Speaker speaker : mSpeakers) {
            speaker.listen(message);
        }
    }

    @Override
    public void listen(Message message) {
        System.out.println(message.getMessage());
    }

    @Override
    public void forget(Message message) {

    }

    @Override
    public void addListener(Speaker user) {

    }

    @Override
    public void removeListener(Speaker user) {

    }

    @Override
    public User getPerson() {
        return currentUser;
    }

}
