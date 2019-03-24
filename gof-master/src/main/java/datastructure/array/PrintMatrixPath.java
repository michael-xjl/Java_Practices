package datastructure.array;

import java.util.ArrayList;

/**
 * @author Michael Liu
 */
public class PrintMatrixPath
{
  public static void main(String[] args)
  {
    final ArrayList<String> printPaths = printPaths(
        new char[][] { { 'a', 'b', 'c' }, { 'e', 'f', 'g' }, { 'h', 'i', 'j' } });
    System.out.println(printPaths);
  }

  public static ArrayList<String> printPaths(char[][] board){

    if(board == null) return null;

    int m = board.length;
    int n = board[0].length;

    ArrayList[][] al = new ArrayList[m][n];

    for(int i = 0; i < m ; i++)
    {
      for(int j = 0; j < n ; j++)
      {
        ArrayList<String> innerAl = new ArrayList<>();
        al[i][j] = innerAl;

        if(i == 0 && j == 0)
          innerAl.add("");
        else if(i == 0)
          innerAl.addAll(al[i][j-1]);
        else if(j == 0)
          innerAl.addAll(al[i-1][j]);
        else
        {
          innerAl.addAll(al[i-1][j]);
          innerAl.addAll(al[i][j-1]);
        }
        final char c = board[i][j];
        innerAl.replaceAll(s -> s+c);

      }
    }

    return al[m-1][n-1];


  }
}
