package amz;

/**
 * @author Michael Liu
 */
public class CountDigits
{
  public static void main(String[] args)
  {

    System.out.println("count digit 2345 : " + countDigit(2345));
    System.out.println("count digit 10 : " + countDigit(10));
    System.out.println("count digit 203 : " + countDigit(203));
    System.out.println("count digit 2 : " + countDigit(2));
  }

  private static int countDigit(int num)
  {
    int count = 0 ;
    while(num != 0)
    {
      num /= 10;

      count++;
    }
    return count ;
  }
}
