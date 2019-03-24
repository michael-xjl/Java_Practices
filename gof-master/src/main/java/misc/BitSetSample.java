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

    /***********************************/
    BitSet bits11 = fromString("1000001");
    BitSet bits22 = fromString("1111111");

    System.out.println(toString(bits11)); // prints 1000001
    System.out.println(toString(bits22)); // prints 1111111

    bits22.and(bits11);

    System.out.println(toString(bits22)); // prints 1000001

    /**************************************/

    BitSet bs1 = new BitSet();
    System.out.println(bs1.isEmpty());

    bs1.set(2);
    System.out.println(bs1);

    printMissingNumber(new int[]{2,1,4},5);
  }

  private static void printMissingNumber(int[] numbers, int count)
  {
    int missingCount = count - numbers.length;
    BitSet bitSet = new BitSet(count);
    for (int number : numbers)
    {
      bitSet.set(number - 1);
      printBits(bitSet);
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

  private static BitSet fromString(final String s) {
    return BitSet.valueOf(new long[] { Long.parseLong(s, 2) });
  }

  private static String toString(BitSet bs) {
    return Long.toString(bs.toLongArray()[0], 2);
  }

  private static void printBits(BitSet b)
  {
    System.out.println(b.toString());
  }

}