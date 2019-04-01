package gof.structural.bridge.abstraction;

import gof.structural.bridge.implementation.EmailMessageSender;
import gof.structural.bridge.implementation.MessageSender;
import gof.structural.bridge.implementation.TextMessageSender;
import org.junit.Test;

import static org.junit.Assert.*;


public class MessageTest {

    @Test
    public void testSend() throws Exception {
      MessageSender textMessageSender=new TextMessageSender();
      Message textMessage=new TextMessage(textMessageSender);
      textMessage.send();

       MessageSender emailMessageSender=new EmailMessageSender();
       Message emailMessage=new TextMessage(emailMessageSender);
       emailMessage.send();


       Message emailMessage2=new EmailMessage(textMessageSender);
      emailMessage2.send();
    }
}