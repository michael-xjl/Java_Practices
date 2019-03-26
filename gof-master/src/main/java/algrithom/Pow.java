package algrithom;

/**
 * @author Michael Liu
 */
public class Pow
{
  public static double pow(double x, int n) {
    if(n==0) return 1;
    if(n==1) return x;
    if(x==0) return x;
    if(n<0) {
      x = 1/x;
      n = -n;
    }
    if(n%2 > 0) { //n is odd
      return x*pow(x*x, n/2);
    } else { //n is even
      return pow(x*x, n/2);
    }
  }

  public static double pow2(double x, int n) {

    boolean negative = false;
    if(n < 0)
    {
      negative = true;
      n = -n;
    }

    if( n == 0)
      return 1;

    double pow = x;

    for(int i = 2 ; i <= n ; i++)
      pow = pow*x;

    if(negative)
      pow = 1/pow;

    return pow;

  }
}
