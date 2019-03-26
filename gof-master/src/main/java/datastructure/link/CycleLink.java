package datastructure.link;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * @author Michael Liu
 */
public class CycleLink
{
  public static void main(String[] args)
  {
    LinkNode l = LinkGenerator.gen(3);
    l.next.next = l;

    System.out.println(isCycleLinkExtraSpace(l));
    System.out.println(isCycleLinkExtraSpace(LinkGenerator.gen(4)));

    System.out.println(isCycleLinkNoExtraSpace(l));
    System.out.println(isCycleLinkNoExtraSpace(LinkGenerator.gen(4)));

    System.out.println(isCycleLinkNoExtraSpace2(l));
    System.out.println(isCycleLinkNoExtraSpace2(LinkGenerator.gen(4)));
  }


  //Big(n)
  public static boolean isCycleLinkExtraSpace(LinkNode node)
  {
    if(node == null || node.next == null)
      return false;

    Set<LinkNode> nodeSet = new HashSet<>();

    while(node != null)
    {
      if(nodeSet.contains(node))
      {
        return true;
      }
      else
      {
        nodeSet.add(node);
        node = node.next;
      }
    }

    return false;

//    HashSet<Node> visited = new HashSet<Node>();
//    for (Node curr = n; curr != null; curr = curr.next) {
//      if (visited.contains(curr)) return true;
//      visited.add(curr);
//    }
//
//    return false;
  }

  //O(2^n)
  public static boolean isCycleLinkNoExtraSpace(LinkNode node)
  {
    if(node == null || node.next == null)
      return false;

    while(node != null)
    {
      LinkNode innerRunner = node.next;
      while(innerRunner != null)
      {
        if(innerRunner == node)
        {
          return true;
        }
        else
        {
           innerRunner = innerRunner.next;
        }
      }

      node = node.next;

    }

    return false;
  }

  //O(2n)
  /**
      1 -> 2 -> 3 -> 4 (-->1)
   s: ^
   f:      ^

   s:      ^
   f:                 ^

   s:           ^
   f:       ^

   s:                  ^
   f:                  ^


      1 -> 2 -> 3 -> 4 (-->2)
   s: ^
   f:      ^

   s:      ^
   f:                ^

   s:           ^
   f:           ^



   **/



  public static boolean isCycleLinkNoExtraSpace2(LinkNode node)
  {
    if(node == null) return false;

    LinkNode slow = node;
    LinkNode fast = node.next; //start point is very important here!!!!!


    while(fast != null && fast.next != null)
    {
      if(fast == slow)
        return true;

      fast = fast.next.next;
      slow = slow.next;
    }

    return false;
  }
  public static boolean isCycleLinkNoExtraSpace3(LinkNode node)
  {
    if(node == null || node.next == null) return false;

    LinkNode slow = node;
    LinkNode fast = node;


    while(fast.next != null && fast.next.next != null)
    {
      fast = fast.next.next;
      slow = slow.next;

      if(fast == slow)
        return true;
    }

    return false;
  }

  public static boolean isCyclic(LinkNode head)
  {
    boolean result = false;
    Hashtable<LinkNode, Integer> nodeTable = new Hashtable<>();
    // Iterate over the list
    while (head != null)
    {
      if (nodeTable.containsKey(head))
      {
        result = true;
        break;
      }
      else
      {
        // add an entry of node's data in hashtable
        nodeTable.put(head, head.val);
        head = head.next;
      }
    }
    return result;
  }
}
