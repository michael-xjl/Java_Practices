package datastructure.array;

/**
 * @author Michael Liu
 */
public class SelectionSort
{
  public static int[] selectionSortArray(int[] arr){

    if(arr == null || arr.length < 2) return arr;

    int start = 0;

    while(start < arr.length)
    {
      for(int i = arr.length - 1; i > start;  i--)
      {
        if(arr[i] < arr[i-1])
        {
          int tmp = arr[i];
          arr[i] = arr[i-1];
          arr[i-1] = tmp;
        }
      }

      start++;
    }

    return arr;
  }
}
