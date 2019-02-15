package algrithom;

import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class PlusOne
{

  public static void main(String[] args)
  {
    int[] a = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};

    final int[] ints = plusOne(a);
    System.out.println(ints);

    int[] b = {0,1,0,3,12};
    System.out.println(Arrays.toString(b));
    moveZeroes(b);
    System.out.println(Arrays.toString(b));


  }

  public static int[] plusOne(int[] digits) {
    long result = 1;
    for(int i = 0 , j = 0; i < digits.length; i++)
    {
      int n = digits[i];
      result += n*Math.pow(10,digits.length-1-i);
    }
    return intToArray(result);
  }

  public static int[] intToArray(long n)
  {
    String ns = String.valueOf(n);
    int nl = ns.length();
    int[] array = new int[nl];

    for(int i = 0 ; i< nl ; i++)
    {
      array[i] =  Integer.parseInt(ns.substring(i,i+1));
    }

    return array;
  }


  public static void moveZeroes(int[] nums) {

    int startIndex = 0;
    int endIndex = nums.length -1;

    for(int i = startIndex ; i < endIndex; i++)
    {
      int n = nums[i];

      if(n == 0)
      {
        int tmp = nums[i];
        for(int j = i ; j < endIndex ; j++)
        {
          nums[j] = nums[j+1];
        }
        nums[endIndex] = tmp;
        endIndex--;
        i--;
      }
    }
  }
}
