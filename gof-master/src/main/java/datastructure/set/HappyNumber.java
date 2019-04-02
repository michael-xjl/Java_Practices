package datastructure.set;

import java.util.HashSet;

/**
 * @author Michael Liu
 */
public class HappyNumber
{

  public static void main(String[] args)
  {
    System.out.println(isHappyNumber(68));
  }

  public static boolean isHappyNumber(int n) {

    if( n < 1) return false;

    HashSet<Integer> hashset = new HashSet<>();

    int happNumber = n;

    while( happNumber != 1)
    {
      happNumber = sunSquares(happNumber);
      if(happNumber == 1)
        return true;

      if(hashset.contains(happNumber))
        break;
      hashset.add(happNumber);
    }


    return false;
  }
  private static int sunSquares(int n)
  {
    int total = 0;
    while(n >= 10)
    {
      int num = n%10;
      total += num * num;
      n /= 10;
    }

    total += n*n;

    return total;
  }
}
