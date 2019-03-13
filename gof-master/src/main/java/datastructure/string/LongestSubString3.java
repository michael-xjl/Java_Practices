package datastructure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Liu
 */
public class LongestSubString3
{
  public static void main(String[] args)
  {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }
  public static int getLongestSubstring(String str)
  {
    StringBuffer sb = new StringBuffer();
    int max = 0;
    char[] chars = str.toCharArray();
    for(char c: chars)
    {
      if(sb.indexOf(String.valueOf(c)) >= 0)
      {
        max = sb.length() > max ? sb.length() : max;
        sb.delete(0,sb.length());
      }
      sb.append(c);
    }

    return max > sb.length() ? max : sb.length();
  }

  public static int lengthOfLongestSubstring(String s) {

    Map<Character,Integer> map = new HashMap<>();
    int i, j,  max = 0;

    for(i = 0, j = 0 ; i < s.length() ; i++)
    {
      if(map.containsKey(s.charAt(i)))
      {
        max = Math.max(max,i - j);
        j = map.get(s.charAt(i)) + 1;
        map.put(s.charAt(i), i);
      }
      else
        map.put(s.charAt(i), i);
    }

    return Math.max(max, i - j );
  }

  public int lengthOfLongestSubstring2(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }
}
