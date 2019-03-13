package misc;

/**
 * @author Michael Liu
 */
public class RegExp
{
  public static void main(String[] args)
  {
    String regexp = "^69.*|.*69$|.*[K|6]{3}|ASH.*";
    System.out.println("ABC-123".matches(regexp));
    System.out.println("ASH-100".matches(regexp));
    System.out.println("ACA-666".matches(regexp));
    System.out.println("691-AAB".matches(regexp));
    System.out.println("619-AAA".matches(regexp));
    System.out.println("619-KKK".matches(regexp));
    System.out.println("ABC-069".matches(regexp));
  }
}
