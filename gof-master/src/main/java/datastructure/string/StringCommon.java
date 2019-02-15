package datastructure.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string and a dictionary HashSet, write a function to determine the minimum number of characters to delete to make a word.
 *
 * eg.
 *
 * dictionary: [“a”, “aa”, “aaa”]
 * query: “abc”
 *
 * output: 2
 *
 * ************************
 * getCombinationByRemove
 *
 * have such combination
 *        abc
 *        / | \
 *      ab ac  bc
 *      /\ /\  /\
 *     a ba c b c
 *
 * *************************

 * getCombinationByChange
 *
 * have such combination
 *1.change position:        abc             acb         bac      bca     cba    cab
 *2.remove one letter:
                   *        / | \
                   *      ab bc  ca
 *                       /\   /\    /\
 *3.change position:
 *                    ab ba bc cb ca ac

 *
 * ************************* *
 *
 *
 * @author Michael Liu
 */
public class StringCommon
{
  public static void main(String[] args)
  {
    String query = "abcd";

    /**
     * bcd
     * acd
     * abd
     * abc
     */
    for(int i = 0 ; i < query.length(); i++)
    {
      String s = query.substring(0,i) + query.substring(i+1);
      System.out.println(s);
    }

    System.out.println("======");
    for(int i = 0 ; i < query.length(); i++)
    {
      String s = query.substring(0,i) + query.substring(i+1);
      System.out.println(s);
      for(int j = 0 ; j < s.length() ; j++)
      {
        String sj = s.substring(0,j) + s.substring(j+1);
        System.out.println(sj);
        for(int k = 0 ; k < sj.length() ; k++)
        {
          String sk = sj.substring(0,k) + sj.substring(k+1);
          System.out.println(sk);
        }
      }

    }

    System.out.println("=============");
    getCombinationByRemove(query);

    System.out.println("=============");
    Set<String> cache = new HashSet<>();
    getCombinationByRemoveExtraSpace(query, cache);
    System.out.println("=============");
    /**
     a
     b
     c
     d
     ab
     ac
     ad
     bc
     bd
     cd
     abc
     abd
     acd
     bcd
     bacd
     */
    cache.stream().sorted(Comparator.comparing(String::length).thenComparing(String::toString)).forEach(System.out::println);

    System.out.println("========get combination by change position");
    getCombinationByChangePosition("abc");

    /**
     * [abc, acb, bac, bca, cab, cba]
     */
    System.out.println("++++++++++permutations++++++");
    permutations("abc");
    permutations("abcd");

  }

  public static void getCombinationByRemove(String query)
  {
    for(int i = 0 ; i < query.length(); i++)
    {
      if(query.length() == 1)
          System.out.println(query);
      else
      {
        String s = query.substring(0,i) + query.substring(i+1);
        getCombinationByRemove(s);
        System.out.println(s);
      }

    }
  }

  public static void getCombinationByRemoveExtraSpace(String query, Set cache)
  {

    for(int i = 0 ; i < query.length(); i++)
    {
      if(query.length() == 1)
      {
        if(!cache.contains(query))
        {
          cache.add(query);
        System.out.println(query);
        }
      }
      else
      {
        String s = query.substring(0,i) + query.substring(i+1);
        getCombinationByRemoveExtraSpace(s, cache);
        if(!cache.contains(query))
        {
          cache.add(query);
          System.out.println(query);
        }
      }

    }
  }

  /**
   * query = abc
   * out: [acb, abc, cba, bac]
   * @param query
   */
  public static void getCombinationByChangePosition(String query)
  {
    int length = query.length();

    Set<String> set = new HashSet<>();

    for(int i = 0 ; i < length ; i++)
    {
      for(int j = 0 ; j < length ; j++)
      {
         char[] chars = query.toCharArray();
         char tmp = chars[i];
         chars[i] = chars[j];
         chars[j] = tmp;

         String str = new String(chars);
         if(!set.contains(str))
           set.add(str);
      }
    }

    System.out.println(set);

  }

  /**
   * query: abc
   * out:  [abc, acb, bac, bca, cab, cba]
   * out : n!
   */
  public static List<String> permutations(String query)
  {
    List<String> result = new ArrayList<>();

    permutations("", query, result);

    System.out.println(result);

    return result;

  }

  private static void permutations(String prefix, String suffix, List<String> result)
  {
      if(suffix.equals(""))
        result.add(prefix);
      else
      {
        for(int i = 0 ; i < suffix.length(); i++)
          permutations(prefix + suffix.charAt(i), suffix.substring(0,i)+ suffix.substring(i+1), result);
      }

  }


  public static List<String> permutationsSubSet(String query)
  {
    List<String> result = new ArrayList<>();

    for(int i = 0 ; i< query.length() ; i++)
    {

      permutations("", query.substring(0,i) + query.substring(i+1), result);
    }


    System.out.println(result);

    return result;

  }
}
