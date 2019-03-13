package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael Liu
 */
public class SortLog
{
  public static void main(String[] args)
  {
//    final List<String> log = new ArrayList<>(Arrays.asList("asda br9o fjsd", "asdA 1df8 sfds", "fdsf 2def sees", "asd1 awer jik9"));
    final List<String> log = new ArrayList<>(Arrays.asList("efe2 br9o fjsd", "fhie 1df8 sfds", "fdsf 2def sees", "asd1 awer jik9"));
//
    log.sort( (l1,l2) ->
    {
      String id1 = l1.substring(l1.indexOf(" "));
      String id2 = l2.substring(l2.indexOf(" "));

      char[] chars1 = id1.toCharArray();
      char[] chars2 = id2.toCharArray();

      int len = chars1.length > chars2.length ? chars1.length : chars2.length;
      for(int i = 0 ; i < len; i++)
      {
        char c1 = chars1[i];
        char c2 = chars2[i];

        if(c1 != c2)
        {
          if(Character.isDigit(c1) && !Character.isDigit(c2))
            return 1;
          else if(!Character.isDigit(c1) && Character.isDigit(c2))
            return -1;
          else
            return c1 - c2;
        }

      }

      return 0;

    });
    System.out.println(log.toString());

    System.out.println("A".compareTo("a"));
    System.out.println((int)'b');
    System.out.println((int)'B');
    System.out.println("A".compareTo("1"));

    final List<String> ascii = Arrays.asList("ada", "ad1", "adA", "adb");
    ascii.sort( ( a1 , a2) ->{
      char[] chars1 = a1.toCharArray();
      char[] chars2 = a2.toCharArray();

      int len = chars1.length > chars2.length ? chars1.length : chars2.length;
      for(int i = 0 ; i < len; i++)
      {
        char c1 = chars1[i];
        char c2 = chars2[i];

        if(c1 != c2)
        {
          if(Character.isDigit(c1) && !Character.isDigit(c2))
            return 1;
          else if(!Character.isDigit(c1) && Character.isDigit(c2))
            return -1;
          else
            return c1 - c2;
        }

      }

      return 0;
    });
    System.out.println(ascii);

  }
}
