package gof.structural.bridge.abstraction;

import gof.structural.bridge.implementation.MessageSender;

public class TextMessage extends Message{

    public TextMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public void send(){
      messageSender.sendMessage();
    }

}
