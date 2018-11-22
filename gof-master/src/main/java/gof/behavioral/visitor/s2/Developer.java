package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public class Developer extends Employee
{
  private String name;

  private String position;

  public Developer(String name, String position)
  {
    this.name = name;
    this.position = position;
  }

  @Override public void showEmployeeDetails()
  {
    System.out.println("Developer's detail information: name + " + name + " , position: " + position);
  }
}
