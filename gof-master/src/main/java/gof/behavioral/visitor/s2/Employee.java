package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public abstract class Employee implements Visitable
{
  abstract void showEmployeeDetails();

  public void accept(Visitor visitor)
  {
    visitor.visit(this);
  }
}
