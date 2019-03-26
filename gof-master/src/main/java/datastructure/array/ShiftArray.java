package datastructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 * [1,2,3,4,5,6] ,
 * shiftRight k =3
 * [4,5,6,1,2,3]
 *  shiftRight k = 1
 * [6,1,2,3,4,5]
 *
 * @author Michael Liu
 */
public class ShiftArray
{

  public static void main(String[] args)
  {

  }

  @Test
  public void testShiftLeft()
  {
    assertArrayEquals(shiftLeft(new int[]{1,2,3,4,5,6,7},5),new int[]{6,7,1,2,3,4,5});
  }
  @Test
  public void testShiftRight()
  {
    assertArrayEquals(shiftRight(new int[]{1,2,3,4,5,6,7},3),new int[]{5,6,7,1,2,3,4});
  }

  public static int[] shiftLeft(int[] arr, int k)
  {
    k = k%arr.length;

    while( k > 0)
    {
      int tmp = arr[0];
      for(int i = 0; i < arr.length - 1  ; i++)
      {
        arr[i] = arr[i+1];
      }
      arr[arr.length - 1] = tmp;

      k--;
    }

    return arr;
  }

  //extra space O(n) , time O(2n)
  public static int[] shiftRight(int[] nums, int k)
  {

    int[] a = new int[nums.length];
    for(int i = 0 ; i < nums.length ; i++)
    {
      a[(i+k)%nums.length] = nums[i];
    }

    for(int i = 0 ; i<nums.length ; i++)
      nums[i] = a[i];

    return nums;
  }

  //space O(1) time O(k*n)
  public static void shiftRight2(int[] nums, int k)
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


  public static int[] rotateLeft(int[] arr, int k)  {
    if (arr == null) return null;
    int actualShifts = k % arr.length;
    reverse(arr, 0, arr.length-1);
    reverse(arr, 0, arr.length - actualShifts-1);
    reverse(arr, arr.length - actualShifts, arr.length-1);
    return arr;
  }

  public static void reverse(int[] arr, int left, int right){
    if(arr == null || arr.length == 1) return;
    while(left < right){
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }
}
