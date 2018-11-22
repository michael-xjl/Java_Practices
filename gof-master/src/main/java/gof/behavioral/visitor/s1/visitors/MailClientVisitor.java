package gof.behavioral.visitor.s1.visitors;


import gof.behavioral.visitor.s1.structure.OperaMailClient;
import gof.behavioral.visitor.s1.structure.SquirrelMailClient;
import gof.behavioral.visitor.s1.structure.ZimbraMailClient;

public interface MailClientVisitor {
    void visit(OperaMailClient mailClient);
    void visit(SquirrelMailClient mailClient);
    void visit(ZimbraMailClient mailClient);
}
