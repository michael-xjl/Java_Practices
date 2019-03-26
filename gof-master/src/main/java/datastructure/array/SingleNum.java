package datastructure.array;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Liu
 */
public class SingleNum
{
  public static void main(String[] args)
  {

    System.out.println(10>>>1);
    System.out.println(10<<5);
    System.out.println(1<<3);
    System.out.println(0|5|3);
    System.out.println(5|5);
    System.out.println(containDuplicate(new int[] { 1, 2, 23, 235 }));
  }

  public static int singleNumber(int[] nums) {
    int result = 0;
    for(int i=0; i<nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }

  public static boolean containDuplicate(int[] nums) {
    int result = nums[0];
    for(int i=1; i<nums.length; i++) {
      if((result | nums[i]) == result)
        return true;

       result |= nums[i];
    }

    return false;
  }

  public static int findMissingNumber(int[] arr) {

    BitSet bs = new BitSet(arr.length+1);

    for(int n : arr)
      bs.set(n-1);

    return bs.nextClearBit(0)+1;

  }

  @Test
  public void testFindMissingNumber()
  {
    assertEquals(4, findMissingNumber(new int[]{1,2,3,5,6,7,8,9}));
  }
}
