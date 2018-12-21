package gof.creational.builder.solution3;

/**
 * @author Michael Liu
 */
public class HouseBuildTest
{
  public static void main(String[] args)
  {
      House house = new House.Builder("f","s","r").furnished(false).painted(true).build();
      System.out.println(house);
      House house2 = new House.Builder("f2","s2","r2").furnished(true).painted(false).build();
      System.out.println(house2);
      House house3 = new House.Builder("f3","s3","r3").build();
      System.out.println(house3);
  }
}
