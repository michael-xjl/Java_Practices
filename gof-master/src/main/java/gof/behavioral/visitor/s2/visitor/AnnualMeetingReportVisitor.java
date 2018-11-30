package gof.behavioral.visitor.s2.visitor;

import gof.behavioral.visitor.s2.visitable.Customer;
import gof.behavioral.visitor.s2.composite.Employee;
import gof.behavioral.visitor.s2.visitable.Order;

/**
 * @author Michael Liu
 */
public class AnnualMeetingReportVisitor implements Visitor
{
  public void visit(Customer visitable){
    System.out.println("AnnualMeetingReportVisitor: print out customer");
  }
  public void visit(Order visitable)
  {
    System.out.println("AnnualMeetingReportVisitor: print out order");
  }

  public void visit(Employee employee)
  {
    System.out.println("AnnualMeetingReportVisitor: print out employee");
    employee.showEmployeeDetails();
  }
}
