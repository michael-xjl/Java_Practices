package datastructure.string;

import java.math.BigInteger;

/**
 * @author Michael Liu
 */
public class ReverseInt
{
  public static void main(String[] args)
  {
    System.out.println("9 ->" +  reverse(9));
    System.out.println("-1290 ->" +  reverse(-1290));
  }

  public static int reverseSmart(int x) {
    boolean flag = false;
    if (x < 0)
      flag = true;
    long input = x;
    input = Math.abs(input);
    long res = 0;
    while (input != 0) {
      res = res * 10 + input % 10;
      input = input / 10;
    }
    return res >= Integer.MAX_VALUE ? 0 : flag ? (int) ( - 1 * res) : (int) res;
  }

  public static int reverse(int x) {

    if(x < 10 && x > -10)
    {
      return x;
    }

    String sx = String.valueOf(x);

    boolean signed = false;
    if(sx.startsWith("-"))
    {
      signed = true;
      sx = sx.substring(1);
    }

    char[] sxa = sx.toCharArray();

    int mid = sxa.length/2;

    int i = 0;
    int j = sxa.length -1;
    for(; i <= mid && j >= mid; i++,j--)
    {
      char tmp = sxa[i];
      sxa[i] = sxa[j];
      sxa[j] = tmp;
    }


    long l = 0;

    int resultLen = sxa.length;

    for(int k = 0 ; k < resultLen;  k++)
    {
      l += Integer.valueOf(String.valueOf(sxa[k])) * Math.pow(10, resultLen -1 -k);
    }


    l = signed ? l*-1 : l;


    return (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) ? 0 : (int)l;


  }

  /**
   * StringBuilder.reverse() has a time complexity of O(n). So this solution should have time complexity of O(n) and space complexity of O(1). This solution is slower than the push/pop digit method, but very straightforward.
   * @param x
   * @return
   */
  public static int reverseByStringBuilder(int x) {
    boolean positive = true;
    if (x == Integer.MIN_VALUE) return 0;
    if (x < 0) {
      positive = false;
      x *= -1;
    }
    StringBuilder x_s = new StringBuilder(String.valueOf(x));
    x_s.reverse();
    BigInteger bi = new BigInteger(x_s.toString());
    BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
    if (bi.compareTo(max) > 0) return 0;
    return positive ? Integer.valueOf(x_s.toString()) : -1 * Integer.valueOf(x_s.toString());
  }
}
