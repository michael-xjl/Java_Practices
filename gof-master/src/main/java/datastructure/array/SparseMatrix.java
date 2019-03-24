package datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * sparse matrix/2d-array
 * @author Michael Liu
 */
public class SparseMatrix<T>
{
  Map<Integer, Map<Integer, T>> matrixMap = new HashMap<>();

  public void put(int x, int y, T val)
  {
    if (matrixMap.get(x) != null)
      matrixMap.get(x).put(y, val);
    else
    {
      HashMap innerMap = new HashMap<>();
      innerMap.put(y, val);
      matrixMap.put(x, innerMap);
    }
  }

  public T get(int x, int y)
  {
    T val = null;
    Map<Integer, T> innerMap = matrixMap.get(x);
    if (innerMap != null)
      val = innerMap.get(y);

    return val;
  }

  //use one HashMap instead of 2
  static class Index
  {

    private int x = 0; // nr of rows
    private int y = 0; // nr of columns
    private int hashvalue = 0;

    public Index(final int x, final int y)
    {
      this.x = x;
      this.y = y;
      hashvalue = ((x + "") + (y + "")).hashCode();
    }

    public boolean equals(final Object obj)
    {
      if (obj instanceof Index)
      {
        Index index = (Index) obj;
        return ((x == index.x) && (y == index.y));
      }
      else
        return false;
    }

    public int hashCode()
    {
      return hashvalue;
    }

  }
}
