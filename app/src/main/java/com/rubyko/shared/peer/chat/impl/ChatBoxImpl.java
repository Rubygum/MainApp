package com.rubyko.shared.peer.chat.impl;

import com.rubyko.client.common.RubykoClient;
import com.rubyko.server.LocalUpdateNetInfo;
import com.rubyko.server.RubykoServer;
import com.rubyko.shared.NetInfo;
import com.rubyko.shared.common.login.model.AccessCard;
import com.rubyko.shared.peer.chat.ChatBox;
import com.rubyko.shared.common.chat.model.Message;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 28.02.16.
 */
public class ChatBoxImpl implements ChatBox, LocalUpdateNetInfo {

    private final AccessCard currentAccessCard;

    private final List<ChatBox> mChatBoxes = new ArrayList<>();
    private final List<Message> mMessages = new ArrayList<>();
    private final String conversationName;

    public ChatBoxImpl(AccessCard accessCard, String conversationName) throws IOException, ClassNotFoundException {
        this.conversationName = conversationName;
        this.currentAccessCard = accessCard;
        this.mChatBoxes.add(this);
        RubykoServer.getInstance().addListener(this);
    }

    @Override
    public void speak(Message message)  {
        for (ChatBox chatBox : mChatBoxes) {
            chatBox.listen(message);
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
    public void addListener(ChatBox user) {

    }

    @Override
    public void removeListener(ChatBox user) {
    }

    @Override
    public AccessCard getPerson() {
        return currentAccessCard;
    }


    @Override
    public void update(ChatBox oldChatBox, NetInfo netInfo) {
        final ChatBox newChatBox = RubykoClient.lookupService(netInfo, ChatBox.class, conversationName);
        for (int i = 0; i < mChatBoxes.size(); i++){
            ChatBox chatBox = mChatBoxes.get(i);
            if(chatBox.equals(oldChatBox)){
                mChatBoxes.remove(i);
                mChatBoxes.add(i, newChatBox);
            }
        }
    }

    @Override
    public void update(NetInfo netInfo) {
        for (ChatBox chatBox : mChatBoxes){
            chatBox.update(this, netInfo);
        }
    }

}
