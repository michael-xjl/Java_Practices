package datastructure.string;

/**
 * @author Michael Liu
 */
public class StringInten
{

  public static void main(String[] args)
  {
    String s1 = "abc";
    String s2 = "abc";

    System.out.println("s1 == s2 : " + (s1 == s2) );
    System.out.println("s1 eqauls s2 : " + s1.equals(s2) );

    String s3 = new String("abc");
    System.out.println("s1 == s3 : " + (s1 == s3) );
    System.out.println("s1 eqauls s3 : " + s1.equals(s3) );

    String s4 = new String("abc").intern();
    System.out.println("s1 == s4 : " + (s1 == s4) );
    System.out.println("s1 eqauls s4 : " + s1.equals(s4) );

    String s5 = "abc".intern();
    System.out.println("s1 == s5 : " + (s1 == s5) );
    System.out.println("s1 eqauls s5 : " + s1.equals(s5) );
  }
}
