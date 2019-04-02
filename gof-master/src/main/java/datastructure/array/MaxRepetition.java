package datastructure.array;

/**
 * @author Michael Liu
 */
public class MaxRepetition
{
  public static void main(String[] args)
  {
    int[] a = new int[]{4,3,1,2,3,3,2,0};

    System.out.println(getMaxRepetition(a));

  }
  public static int getMaxRepetition(int[] a) {
    int max = a.length;
    // Iterate though input array, for every element a[i],
    // increment a[a[i]%k] by k
    for (int i = 0; i< a.length; i++)
    {
      a[a[i]%max] += max;
    }
    // Find index of the maximum repeating element
    int maxr = a[0], result = 0;
    for (int i = 1; i < a.length; i++)
    {
      if (a[i] > maxr)
      {
        maxr = a[i];
        result = i;
      }
    }
    return result;
  }
}
