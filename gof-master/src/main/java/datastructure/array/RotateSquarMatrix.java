package datastructure.array;

/**
 * @author Michael Liu
 */
public class RotateSquarMatrix
{

  public static void main(String[] args)
  {
      int[][] matrix = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
      print(matrix);
      rotateSquareImageCCW(matrix);
      print(matrix);
  }

  public static void print(int[][] matrix)
  {
    int m = matrix.length;
    int n = matrix[0].length;

    StringBuffer sb = new StringBuffer();
    sb.append("{");
    for(int i = 0 ; i < m ; i++)
    {
      sb.append("{");
      for(int j = 0 ; j < n ; j++)
      {
        sb.append(matrix[i][j]);
        if(j < n -1 )
          sb.append(",");
      }

      if(i < m -1 )
        sb.append(",");

      sb.append("}");

    }
    sb.append("}");

    System.out.println(sb.toString());

  }

  public static void rotateSquareImageCCW(int[][] matrix) {

    int len = matrix.length;
    int w = len;
    for(int i = 0 ; i  < len ; i++)
    {

      for(int j = 0 ;j < w ; j++)
      {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[len -1 - j][len - 1 - i];
        matrix[len -1 - j][len - 1 - i] = tmp;
      }
      w--;
    }

    for(int i = 0 ; i  < len ; i++)
    {
      for(int j = 0 ;j < len/2 ; j++)
      {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][len - 1 - j];
        matrix[i][len - 1 - j] = tmp;
      }
    }
  }
}
