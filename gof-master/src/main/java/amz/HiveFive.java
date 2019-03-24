package amz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * @author Michael Liu
 */
public class HiveFive
{

  public static void main(String[] args)
  {
    List<Score> scores = new ArrayList<>();
    for(int i = 1 ; i <= 10 ; i++)
    {
      for(int j = 1; j < 7 ; j++)
      {
        scores.add(new Score(i,j));
      }
    }

    System.out.println(scores);

    scores.sort( (s1,s2) -> {

      if( s1.id == s2.id)
      {
        return s2.val - s1.val;
      }
      else
      {
        return s1.id - s2.id;
      }

    });
    System.out.println(scores);
  }

  private static class Score
  {
    public int id;
    int val;

    public int getId()
    {
      return id;
    }

    public int getVal()
    {
      return val;
    }

    public Score(int id, int val)
    {
      this.id = id;
      this.val = val;
    }

    public String toString()
    {
      return id + "_" + val;
    }
  }
}
