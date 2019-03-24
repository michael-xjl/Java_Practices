package datastructure.trie;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Michael Liu
 */
public class AutoCompleting
{
  TrieNode trie;

  public AutoCompleting(String[] dict)
  {
    trie = Tries.buildTrie(dict);
  }

  public static void main(String[] args)
  {
    AutoCompleting ac = new AutoCompleting(new String[] { "a", "abc", "adf", "abe", "agh", "bef", "bed", "good" });

    System.out.println(ac);

    System.out.println(ac.findWordsByPrefix("a"));
    System.out.println(ac.findWordsByPrefix("ab"));
    System.out.println(ac.findWordsByPrefix("b"));
    System.out.println(ac.findWordsByPrefix("goo"));
  }

  public List<String> findWordsByPrefix(String pre)
  {
    List<String> words = new LinkedList<>();

    TrieNode curr = trie;

    for (int i = 0; i < pre.length(); i++)
    {
      if (!curr.childenMap.containsKey(pre.charAt(i)))
      {
        return null;
      }
      curr = curr.childenMap.get(pre.charAt(i));
    }

    //    if(curr.isWord)
    //    {
    //      words.add(curr.prefix);
    //    }

    getAllPrefixes(curr, words);

    return words;
  }

  private void getAllPrefixes(TrieNode trie, List words)
  {
    //base case
    if (trie.isWord)
      words.add(trie.prefix);

    //recursive the children trie nodes
    if (trie.childenMap != null)
      for (TrieNode cTriNode : trie.childenMap.values())
      {
        getAllPrefixes(cTriNode, words);
      }

  }
}
