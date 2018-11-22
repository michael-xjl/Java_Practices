package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public interface Visitor
{
  void visit(Customer visitable);
  void visit(Order visitable);
  void visit(Employee visitable);
}
