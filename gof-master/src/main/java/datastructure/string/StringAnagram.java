package datastructure.string;

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
}
