package gof.behavioral.visitor.s1.visitors;


import gof.behavioral.visitor.s1.structure.OperaMailClient;
import gof.behavioral.visitor.s1.structure.SquirrelMailClient;
import gof.behavioral.visitor.s1.structure.ZimbraMailClient;

public class LinuxMailClientVisitor implements MailClientVisitor{
    @Override
    public void visit(OperaMailClient mailClient) {
      System.out.println("Configuration of Opera mail client for Linux complete");
    }

    @Override
    public void visit(SquirrelMailClient mailClient) {
        System.out.println("Configuration of Squirrel mail client for Linux complete");

    }

    @Override
    public void visit(ZimbraMailClient mailClient) {
        System.out.println("Configuration of Zimbra mail client for Linux complete");

    }
}
