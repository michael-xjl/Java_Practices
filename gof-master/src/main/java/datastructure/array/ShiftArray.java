package datastructure.array;

import java.util.Arrays;

/**
 *
 * [1,2,3,4,5,6] ,
 * shift k =3
 * [4,5,6,1,2,3]
 *  shift k = 1
 * [6,1,2,3,4,5]
 *
 * @author Michael Liu
 */
public class ShiftArray
{

  public static void main(String[] args)
  {
    int[] a = new int[]{1,2,3,4,5,6,7};

    shift(a,3);
    System.out.println(Arrays.toString(a));
    shift2(a,3);
    System.out.println(Arrays.toString(a));
  }
  public static void shift(int[] nums, int k)
  {

    int[] a = new int[nums.length];
    for(int i = 0 ; i < nums.length ; i++)
    {
      a[(i+k)%nums.length] = nums[i];
    }

    for(int i = 0 ; i<nums.length ; i++)
      nums[i] = a[i];

  }

  public static void shift2(int[] nums, int k)
  {

    k = k%nums.length;

    while(k > 0)
    {
      int tmp = nums[nums.length - 1];
      for(int i = nums.length - 1 ; i > 0  ; i-- )
      {
        nums[i] = nums[i-1];
      }
      nums[0] = tmp;

      k--;
    }

  }
}
