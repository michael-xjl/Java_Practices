package datastructure.array;

import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class MergeArray
{
  public static void main(String[] args)
  {
    int[] num1 = {1,3,5,9,0,0,0};
    int[] num2 = {1,2,5};

    mergeArray(num1, 4, num2,3);

    System.out.println(Arrays.toString(num1));

    num1 =  new int[]{1,2,3,4,0,0,0};
    mergeArray(num1, 4, new int[]{},0);
    System.out.println(Arrays.toString(num1));
  }

  private static void mergeArray(int[] num1, int m, int[] num2, int n)
  {
    int[] a = new int[num1.length];

    int m1 = 0 , n1 = 0, a1 = 0;

    while(m1 <= m -1 && n1 <= n -1 )
    {
      if(num1[m1] < num2[n1])
      {
        a[a1] = num1[m1];

        m1++;
      }
      else
      {
        a[a1] = num2[n1];

        n1++;
      }
      a1++;
    }

    if(m1 < m -1)
      System.arraycopy(num1,m1,a,a1,m-m1);
    else
      System.arraycopy(num2,n1,a,a1,n-n1);

    System.arraycopy(a,0, num1, 0, num1.length);
  }
}
