package gof.behavioral.visitor.visitors;


import gof.behavioral.visitor.structure.OperaMailClient;
import gof.behavioral.visitor.structure.SquirrelMailClient;
import gof.behavioral.visitor.structure.ZimbraMailClient;

public interface MailClientVisitor {
    void visit(OperaMailClient mailClient);
    void visit(SquirrelMailClient mailClient);
    void visit(ZimbraMailClient mailClient);
}
