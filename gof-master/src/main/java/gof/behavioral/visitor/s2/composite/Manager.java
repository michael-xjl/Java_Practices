package gof.behavioral.visitor.s2.composite;

/**
 * @author Michael Liu
 */
public class Manager extends Employee
{
  private String name;

  private String position;

  public Manager(String name, String position)
  {
    this.name = name;
    this.position = position;
  }

  @Override public void showEmployeeDetails()
  {
    System.out.println("Manager's detail information: name + " + name + " , position: " + position);
  }
}
