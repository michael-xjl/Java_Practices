package datastructure.trie;

/**
 * @author Michael Liu
 */
public class TrieHelper
{
  public static TrieNode buildTrie(String[] strs)
  {
    TrieNode root = new TrieNode("");

    for(String s : strs)
    {
      TrieNode curr = root;
      for(int i = 0 ; i < s.length()  ; i ++)
      {
        if(!curr.childenMap.containsKey(s.charAt(i)))
        {
          curr.childenMap.put(s.charAt(i), new TrieNode(s.substring(0, i+1)));
        }
        curr =  curr.childenMap.get(s.charAt(i));
        if(i  == s.length() -1 )
          curr.isWord = true;
      }
    }

    return root;
  }

}
