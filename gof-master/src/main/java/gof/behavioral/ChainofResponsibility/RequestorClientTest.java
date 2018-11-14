package gof.behavioral.ChainofResponsibility;

import gof.behavioral.ChainofResponsibility.handlers.AbstractSupportHandler;
import org.junit.Test;

public class RequestorClientTest {

    @Test
    public void testGetHandlerChain() throws Exception {

        AbstractSupportHandler handler=RequestorClient.getHandlerChain();
      handler.receiveRequest(AbstractSupportHandler.TECHNICAL, " I'm having problem with my internet connectivity.");
        System.out.println("............................................");
      handler.receiveRequest(AbstractSupportHandler.BILLING, "Please resend my bill of this month.");
        System.out.println("............................................");
      handler.receiveRequest(AbstractSupportHandler.GENERAL, "Please send any other plans for home users.");
    }
}