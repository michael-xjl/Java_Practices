package datastructure.trie;

import java.util.HashMap;

/**
 * @author Michael Liu
 */
// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

class TrieNode2 {
  Character c;
  Boolean isLeaf = false;
  HashMap<Character, TrieNode2> children = new HashMap<>();
  public TrieNode2() {}
  public TrieNode2(Character c) {
    this.c = c;
  }
}

public class Trie {
  private TrieNode2 root;

  // Implement these methods :
  public Trie() {
    root = new TrieNode2(null);
  }


  public void insertWord(String word) {

    HashMap<Character, TrieNode2> curr = root.children;

    if(word == null || word.equals(""))
      return;

    for(int i = 0 ; i < word.length() ; i++)
    {
      char c = word.charAt(i);

      TrieNode2 node = null;

      if(curr.containsKey(c))
      {
        node = curr.get(c);
      }

      if(node == null)
        node = new TrieNode2(c);

      if(i == word.length() -1 )
        node.isLeaf = true;

      curr.put(c, node);

      curr = node.children;
    }

  }
  public Boolean searchWord(String word) {

    HashMap<Character, TrieNode2> curr = root.children;

    if(word == null || word.equals(""))
      return false;

    for(int i = 0 ; i < word.length() ; i++)
    {
      char c = word.charAt(i);

      if(!curr.containsKey(c))
        return false;

      if(i == word.length() -1 && !curr.get(c).isLeaf)
        return false;

      curr = curr.get(c).children;
    }

    return true;


  }
  public Boolean searchPrefix(String word) {

    HashMap<Character, TrieNode2> curr = root.children;

    if(word == null || word.equals(""))
      return false;

    for(int i = 0 ; i < word.length() ; i++)
    {
      char c = word.charAt(i);

      if(!curr.containsKey(c))
        return false;

      if(i == word.length() -1 && curr.get(c).isLeaf)
        return false;

      curr = curr.get(c).children;
    }

    return true;

  }
}