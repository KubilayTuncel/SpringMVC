package com.tpe.service;

import com.tpe.domain.Message;

public class WhatsuppService implements MessageService{

    public void sendMessage(Message message) {
        System.out.println("Ben whatsupp servisiyim, size mesaj gönderiyorum : "+message.getMessage());
    }
}
