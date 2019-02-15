package algrithom;

/**
 * @author Michael Liu
 */
public class IntLength
{
  public static int getLength(int n)
  {


    int i = 1;

    if ( n == Integer.MIN_VALUE)
       n = n +1;

    n = n < 0 ? n*-1 : n;

    for( ; n > 10 ; ++i)
    {
      n /= 10;
    }

    return i;

  }
}
