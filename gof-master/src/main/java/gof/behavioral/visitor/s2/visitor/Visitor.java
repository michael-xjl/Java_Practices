package gof.behavioral.visitor.s2.visitor;

import gof.behavioral.visitor.s2.visitable.Customer;
import gof.behavioral.visitor.s2.composite.Employee;
import gof.behavioral.visitor.s2.visitable.Order;

/**
 * @author Michael Liu
 */
public interface Visitor
{
  void visit(Customer visitable);
  void visit(Order visitable);
  void visit(Employee visitable);
}
