package datastructure.trie;

import java.util.HashMap;

/**
 * @author Michael Liu
 */
public class TrieNode
{
  String prefix;
  HashMap<Character, TrieNode> childenMap;
  boolean isWord;

  public TrieNode(String prefix)
  {
    this.prefix = prefix;
    this.childenMap = new HashMap<>();
  }
}
