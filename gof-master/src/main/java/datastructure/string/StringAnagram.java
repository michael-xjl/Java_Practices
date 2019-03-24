package datastructure.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Michael Liu
 *
 * atom is anagram of moat
 */
public class StringAnagram
{
  public static void main(String[] args)
  {
    System.out.println(isAnagram("abc","cab"));
    System.out.println(isAnagram("abd","cab"));

    System.out.println(isAnagram2("abc","cab"));
    System.out.println(isAnagram2("abd","cab"));

  }

  public static boolean isAnagram(String s1, String s2)
  {
    int[] letters = new int[1 << 8]; //256 ascii letters

    for (char c1 : s1.toCharArray())
      letters[c1]++;

    for (char c2 : s2.toCharArray())
      letters[c2]--;

    for (int letter : letters)
      if (letter > 0)
        return false;

    return true;
  }


  public static boolean isAnagram2(String s1, String s2)
  {
    int[] letters = new int[26]; //256 ascii letters

    for(int i = 0 ; i < s1.length() ; i++)
    {
      letters[s1.charAt(i) - 'a'] ++;
      letters[s2.charAt(i) - 'a'] --;
    }
    for (int letter : letters)
      if (letter > 0)
        return false;

    return true;
  }
}
