package misc;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Michael Liu
 */
public class BitSetSample
{
  public static void main(String[] args)
  {
    BitSet bits1 = new BitSet();
    BitSet bits2 = new BitSet();

    bits2.set(1000001);
    bits1.set(1111111);

    bits2.and(bits1);

    System.out.println(bits2);

    BitSet bs1 = new BitSet();
    System.out.println(bs1.isEmpty());

    bs1.set(2);
    System.out.println(bs1);

    printMissingNumber(new int[]{1,2,4,5},5);
  }

  private static void printMissingNumber(int[] numbers, int count)
  {
    int missingCount = count - numbers.length;
    BitSet bitSet = new BitSet(count);
    for (int number : numbers)
    {
      bitSet.set(number - 1);
    }
    System.out
        .printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
    int lastMissingIndex = 0;
    for (int i = 0; i < missingCount; i++)
    {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex);
    }
  }

}