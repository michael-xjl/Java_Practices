package gof.creational.builder.solution4;

/**
 * @author Michael Liu
 */
public class HouseBuildTest
{
  public static void main(String[] args)
  {
    final HouseBuilder houseBuilder = new HouseBuilder("f", "s", "r");
      House house = houseBuilder.furnished(false).painted(true).build();
      System.out.println(house);

      House house1 = new House(houseBuilder);
      System.out.println(house1);

      House house2 = new HouseBuilder("f2","s2","r2").furnished(true).painted(false).build();
      System.out.println(house2);

      House house3 = new HouseBuilder("f3","s3","r3").build();
      System.out.println(house3);

      House house4 = new House(null);
      System.out.println(house4);
  }
}
