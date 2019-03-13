package algrithom.dp;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 *
 * Given a number n, the task is to find n’th Ugly number.
 *
 * Examples:
 *
 * Input  : n = 7
 * Output : 8
 *
 * Input  : n = 10
 * Output : 12
 *
 * Input  : n = 15
 * Output : 24
 *
 * Input  : n = 150
 * Output : 5832
 *
 * @author Michael Liu
 */
public class UglyNum
{
  public static void main(String[] args)
  {
    System.out.println(getUgly(1));
    System.out.println(getUgly(4));
    System.out.println(getUgly(10));
    System.out.println(getUgly(150));
  }
  public static int getUgly(int kth)
  {
    if(kth == 1)
      return 1;

    kth--;

    for(int i = 2 ; i < Integer.MAX_VALUE; i++)
    {
      if(isUgly(i))
        kth--;

      if(kth == 0)
        return i;
    }

    return  -1;


  }

  private static boolean isUgly(int n)
  {
    n = maxDivide(n, 2);
    n = maxDivide(n, 3);
    n = maxDivide(n, 5);

    return n == 1;
  }

  private static int maxDivide(int a, int b)
  {
    while(a%b == 0)
      a = a/b;

    return a;
  }
}
