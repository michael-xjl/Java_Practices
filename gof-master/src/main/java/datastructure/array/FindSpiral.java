package datastructure.array;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 * Let's have some fun with 2D Matrices! Write a method FindSpiral to traverse a 2D matrix of ints in a clockwise spiral order and append the elements to an output ArrayList if Integers.
 *
 *
 *
 * Example:
 *
 * Input Matrix :
 *
 *     {1, 2, 3}
 *
 *     {4, 5, 6}
 *
 *     {7, 8, 9}
 *
 * Output ArrayList:[1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * @author Michael Liu
 */
public class FindSpiral
{
  @Test
  public void testFindSpiral()
  {
    int[][] arr = new int[][]{
        {1,2,3,4,5},
        {6,7,8,9,10},
        {11,12,13,14,15},
        {16,17,18,19,20},
        {21,22,23,24,25}
    };

    final ArrayList<Integer> spiral = findSpiral(arr);
    assertEquals("[1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13]",  spiral.toString());
  }

  public static ArrayList<Integer> findSpiral(int[][] arr) {
    ArrayList<Integer> spiralOrder = new ArrayList<Integer>();
    if(arr == null || arr.length == 0) return spiralOrder;
    int m = arr.length, n = arr[0].length;
    int x=0, y=0;
    while(m>0 && n>0){
      if(m==1){
        for(int i=0; i<n; i++)
          spiralOrder.add(arr[x][y++]);
        break;
      }else if(n==1){
        for(int i=0; i<m; i++)
          spiralOrder.add(arr[x++][y]);
        break;
      }

      //** n-1 and m -1
      for(int i=0;i<n-1;i++)
        spiralOrder.add(arr[x][y++]);
      for(int j=0;j<m-1;j++)
        spiralOrder.add(arr[x++][y]);
      for(int i=0;i<n-1;i++)
        spiralOrder.add(arr[x][y--]);
      for(int j=0;j<m-1;j++)
        spiralOrder.add(arr[x--][y]);
      x++;
      y++;
      m=m-2;
      n=n-2;
    }
    return spiralOrder;
  }
}
