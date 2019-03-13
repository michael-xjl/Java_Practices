package amz;

import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class ArrayDescendingSort
{

  public static void main(String[] args)
  {
    System.out.println(Arrays.toString(sortDescending(new int[]{5,2,1,9,13,4})));
  }

  private static int[] sortDescending(int[] nums)
  {
    int i , j , location, max , len = nums.length;

    for(i = 0 ; i < len ; i++)
    {
      max = nums[i];
      location = i;
      for(j = i ; j < len; j++)
      {
        if(max < nums[j])
        {
          max = nums[j];
          location = j;
        }
      }

      nums[location] = nums[i];
      nums[i] = max;

    }

    return nums;
  }
}
