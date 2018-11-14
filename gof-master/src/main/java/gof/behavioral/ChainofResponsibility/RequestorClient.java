package gof.behavioral.ChainofResponsibility;

        import gof.behavioral.ChainofResponsibility.handlers.BillingSupportHandler;
        import gof.behavioral.ChainofResponsibility.handlers.AbstractSupportHandler;
        import gof.behavioral.ChainofResponsibility.handlers.GeneralSupportHandler;
        import gof.behavioral.ChainofResponsibility.handlers.TechnicalSupportHandler;

public class RequestorClient {

    public  static AbstractSupportHandler getHandlerChain(){


        AbstractSupportHandler technicalSupportHandler = new TechnicalSupportHandler( AbstractSupportHandler.TECHNICAL);
        AbstractSupportHandler billingSupportHandler = new BillingSupportHandler(  AbstractSupportHandler.BILLING);
        AbstractSupportHandler generalSupportHandler = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);

        technicalSupportHandler.setNextHandler(billingSupportHandler);
        billingSupportHandler.setNextHandler(generalSupportHandler);

        return technicalSupportHandler;
    }

}
