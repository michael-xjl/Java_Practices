package algrithom;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * @author Michael Liu
 */
public class BitWise
{
  public static void main(String[] args)
  {
    final int solution = solution(5, 8);
    System.out.println(solution);

    System.out.println(findXORofRange(5, 8));

    int xor1 = 5;
    int xor2 = 1;
    for(int i = 6; i<=1000000000; i++)
      xor1 ^= i;



    System.out.println(xor1);


  }

    public static int solution(int M, int N) {
      // write your code in Java SE 8
      if(M > N || M < 0  || N < 0)
        return 0;

      BitSet bs1 =  BitSet.valueOf(new long[]{M});
      for(int i = M+1 ; i <= N ; i++)
      {
        bs1.xor(BitSet.valueOf(new long[]{i}));
      }

      return (int)(bs1.toLongArray()[0]);

    }

  public static int findXORofRange(int M, int N) {

    int[] backMemory;

    if(M % 2 == 0)
      backMemory = new int[] {N, 1, N^1, 0};
    else
      backMemory = new int[] {M, M^N, M-1, (M-1)^N};

    return backMemory[(N-M) % 4];
  }

  static int computeXOR(int n)
  {
    // If n is a multiple of 4
    if (n % 4 == 0)
      return n;

    // If n%4 gives remainder 1
    if (n % 4 == 1)
      return 1;

    // If n%4 gives remainder 2
    if (n % 4 == 2)
      return n + 1;

    // If n%4 gives remainder 3
    return 0;
  }

}
