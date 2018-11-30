package gof.behavioral.visitor.s2;

import gof.behavioral.visitor.s2.composite.Developer;
import gof.behavioral.visitor.s2.composite.EmployeeGroup;
import gof.behavioral.visitor.s2.composite.Manager;
import gof.behavioral.visitor.s2.visitable.Customer;
import gof.behavioral.visitor.s2.visitable.Order;
import gof.behavioral.visitor.s2.visitable.Visitable;
import gof.behavioral.visitor.s2.visitor.AnnualMeetingReportVisitor;
import gof.behavioral.visitor.s2.visitor.FiscalReportVisitor;

/**
 * @author Michael Liu
 */
public class Main
{
  public static void main(String[] args)
  {

    //Visitor Pattern

    Visitable[] visitables = {new Customer(), new Order()};

    System.out.println( "++++++++++++++++");
    for(Visitable v : visitables)
    {
      v.accept(new FiscalReportVisitor());
    }

    System.out.println( "++++++++++++++++");
    for(Visitable v : visitables)
    {
      v.accept(new AnnualMeetingReportVisitor());
    }


    //Composite Pattern
    System.out.println( "++++++++++++++++");
    Developer dev1 = new Developer("Michael Liu", "Pro Developer");
    Developer dev2 = new Developer( "XJL", "Developer");
    EmployeeGroup devGroup = new EmployeeGroup();
    devGroup.addEmployee(dev1);
    devGroup.addEmployee(dev2);

    Manager man1 = new Manager( "Liu's Manager", "SEO Manager");
    Manager man2 = new Manager( "Liu's Second Manager ", "Dept Manager");

    EmployeeGroup managerGroup = new EmployeeGroup();
    managerGroup.addEmployee(man1);
    managerGroup.addEmployee(man2);

    EmployeeGroup employeeGroup = new EmployeeGroup();
    employeeGroup.addEmployee(devGroup);
    employeeGroup.addEmployee(managerGroup);
    employeeGroup.showEmployeeDetails();

    //Visitor Pattern and Composite Together

    Visitable[] mixedVisitables = {new Customer(), new Order(), employeeGroup};
    System.out.println( "++++++++++++++++");
    for(Visitable v : mixedVisitables)
    {
      v.accept(new AnnualMeetingReportVisitor());
    }
  }
}
