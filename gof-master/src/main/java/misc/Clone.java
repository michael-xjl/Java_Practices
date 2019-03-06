package misc;

/**
 * @author Michael Liu
 */
public class Clone
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    Student sa = new Student("student A");
    System.out.println(sa);
    Student cloned = (Student)sa.clone();
    System.out.println(cloned);
  }

  static class Student implements Cloneable
  {
    String name;

    public Student(String name)
    {
      this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
      return super.clone();
    }

    @Override
    public String toString()
    {
      return super.toString() + "[" + name + "]";
    }
  }
}
