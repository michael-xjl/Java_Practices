package algrithom.dp;

/**
 * @author Michael Liu
 */
public class Fibonacci
{
  public static void main(String[] args)
  {
    System.out.println("------------recursion ----------");
    System.out.println(getFib1(-5));
    System.out.println(getFib1(0));
    System.out.println(getFib1(1));
    System.out.println(getFib2(2));
    System.out.println(getFib1(3));
    System.out.println(getFib1(9));

    System.out.println("------------dynamic programing ----------");
    System.out.println(getFib2(-5));
    System.out.println(getFib2(0));
    System.out.println(getFib2(1));
    System.out.println(getFib2(2));
    System.out.println(getFib2(3));
    System.out.println(getFib2(9));

    System.out.println("------------dynamic programing optimize ----------");
    System.out.println(getFib3(-5));
    System.out.println(getFib3(0));
    System.out.println(getFib3(1));
    System.out.println(getFib3(2));
    System.out.println(getFib3(3));
    System.out.println(getFib3(9));
  }

  /**
   * recursion, time complexity is exponential O(2^n)
   * @param n
   * @return
   */
  public static int getFib1(int n)
  {
    if(n < 0)
      return 0;
    if(n <= 1)
      return n;

    return getFib1(n - 1) + getFib1(n - 2);
  }

  /**
   * space complexity:  Big(n)
   * time complexity : Big(n)
   * @param n
   * @return
   */
  public static int getFib2(int n)
  {
    //rethinking:::
    //how about n <= 0?
    //how about n = 1?
    if(n <= 0)
      return 0;

    int[] f = new int[n+1]; //**** array size is imprtatnt !!!
    f[0] = 0;
    f[1] = 1;
    //:::: local variable is not needed
//    int total = f[1];
    for (int i = 2; i <= n ; i++)
    {
      f[i] = f[i-1] + f[i-2];
//      total += f[i];
    }

//    return total;

    return f[n];

  }

  /**
   * optimize space used in getFib2
   * Time Complexity:O(n)
   * Extra Space: O(1)
   * @param n
   * @return
   */
  public static int getFib3(int n)
  {
    if(n <= 0)
      return 0;

    int a = 0 , b = 1, c ;

    for (int i = 2 ; i <= n ; i++)
    {
      c = a + b;
      a = b;
      b = c;
    }

    return b;

  }
}
