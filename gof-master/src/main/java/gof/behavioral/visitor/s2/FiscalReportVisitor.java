package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public class FiscalReportVisitor implements Visitor
{
  public void visit(Customer visitable)
  {
    System.out.println("This is fiancial report . -> print out customer");
  }

  public void visit(Order visitable)
  {
    System.out.println("This is also fiancial report --> print out order");
  }

  public void visit(Employee employee)
  {
    System.out.println("This is also fiancial report --> print out employee");
    employee.showEmployeeDetails();
  }
}
