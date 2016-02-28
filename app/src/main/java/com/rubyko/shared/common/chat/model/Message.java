package com.rubyko.shared.common.chat.model;

import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public class Message implements Serializable {

    private final String mMessage;

    public Message(String message){
        this.mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }
}
