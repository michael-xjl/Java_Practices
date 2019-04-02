package algrithom;

import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class Permutation
{
  public static void main(String[] args)
  {
    int[] nums = {1,2,3,4};

    int n = nums.length;

    for(int i = 0; i < n ; i++)
    {
      for(int j = 0 ; j < n-1; j++)
      {
        int tmp = nums[j+1];
        nums[j+1] = nums[j];
        nums[j] = tmp;
        System.out.println(Arrays.toString(nums));
      }
    }
  }


}
