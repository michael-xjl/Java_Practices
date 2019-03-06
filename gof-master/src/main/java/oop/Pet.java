package oop;

/**
 * @author Michael Liu
 */
public class Pet implements PetIfc
{
  public void speak()
  {
    System.out.println(" class speaking");
  }



  static void jump2()
  {
    System.out.println("class level jump2");
  }

  public static void main(String[] args)
  {
    PetIfc.jump2();
    Pet.jump2();


    int i = 0, j = 0;

    System.out.println("---------");
    PetIfc pifc = new Pet();
    pifc.speak();
    pifc.jump();
    System.out.println("---------");
    Pet p = new Pet();
    p.speak();
    p.jump();
    p.jump2();
  }

}

interface PetIfc
{
  void speak();

  public default void jump()
  {
    System.out.println("interface jump");
    speak();
  }

  static void jump2()
  {
    System.out.println("interface level jump2");

  }

}
