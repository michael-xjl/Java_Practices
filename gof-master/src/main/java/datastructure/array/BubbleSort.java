package datastructure.array;

import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class BubbleSort
{

  public static void main(String[] args)
  {
    final int[] arr = { 2, 3, 9, 1, 13, 8 };
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void bubbleSort(int[] arr)
  {
    if(arr == null || arr.length < 2)
      return;

    int end = arr.length;

    while(end >= 0 )
    {
      for(int i = 0 ; i < end - 1; i ++)
      {
        if(arr[i] > arr[i+1])
        {
          int tmp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = tmp;
        }

      }
      end --;
    }


  }
}
