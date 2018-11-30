package gof.behavioral.visitor.s2.composite;

import gof.behavioral.visitor.s2.visitable.Visitable;
import gof.behavioral.visitor.s2.visitor.Visitor;

/**
 * @author Michael Liu
 */
public abstract class Employee implements Visitable
{
  public abstract void showEmployeeDetails();

  public void accept(Visitor visitor)
  {
    visitor.visit(this);
  }
}
