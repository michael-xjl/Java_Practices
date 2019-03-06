package datastructure.link;

/**
 * @author Michael Liu
 */
public class DeleteNode
{
  public static void main(String[] args)
  {
    LinkNode head = new LinkNode(5);
    head.next = new LinkNode(4);
    head.next.next = new LinkNode(3);
    head.next.next.next = new LinkNode(2);
    head.next.next.next.next = new LinkNode(2);
    head.next.next.next.next.next = new LinkNode(1);

    System.out.println(head);
    System.out.println(LinkGenerator.gen(10));

    LinkNode d = deleteNodeByVal(head, 2);
    System.out.println(d);

    System.out.println("---------del by end index-------");
    LinkNode dbyend = LinkGenerator.gen(10);
    System.out.println(dbyend);

    System.out.println(deleteNodeNthEnd(dbyend, 3));

    dbyend = LinkGenerator.gen(new int[] { 1, 2, 3, 4, 5, 6 });
    System.out.println(dbyend);
    deleteCurrentNode(dbyend.next.next);
    System.out.println(dbyend);

    head = new LinkNode(5);
    head.next = new LinkNode(4);
    head.next.next = new LinkNode(4);
    head.next.next.next = new LinkNode(2);
    head.next.next.next.next = new LinkNode(2);
    head.next.next.next.next.next = new LinkNode(1);
    System.out.println(head);
    System.out.println(deleteDuplicated(head));

    head = LinkGenerator.gen(1);
    System.out.println(head);
    System.out.println(deleteLastNode(head));

    head = LinkGenerator.gen(2);
    System.out.println(head);
    System.out.println(deleteLastNode(head));

    head = LinkGenerator.gen(5);
    System.out.println(head);
    System.out.println(deleteLastNode(head));

    System.out.println(deleteLastNode(null));

    System.out.println(deleteDuplicatesInUnsorted(LinkGenerator.gen(new int[] { 2, 2 })));
    System.out.println(deleteDuplicatesInUnsorted(LinkGenerator.gen(new int[] { 2 })));
    // System.out.println(deleteDuplicatesInUnsorted(LinkGenerator.gen(null)));
    System.out.println(deleteDuplicatesInUnsorted(LinkGenerator.gen(new int[] {})));
    System.out
        .println(deleteDuplicatesInUnsorted(LinkGenerator.gen(new int[] { 9, 1, 1, 2, 3, 5, 1, 1, 2, 2, 3, 2, 7 })));
  }

  public static LinkNode deleteNodeByVal(LinkNode head, int val)
  {

    if (head == null)
      return null;

    LinkNode help = head;

    while (help.next != null)
    {
      if (help.next.val == val)
      {
        help.next = help.next.next;
      }
      else
      {
        help = help.next;
      }
    }

    return head.val == val ? head.next : head;

  }

  public static LinkNode deleteNodeNthEnd(LinkNode head, int index)
  {
    LinkNode fast, slow;
    fast = slow = head;

    for (int i = 0; i < index; i++)
    {
      fast = fast.next;
    }

    while (fast.next != null)
    {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;

  }

  public static void deleteCurrentNode(LinkNode del)
  {
    while (del.next.next != null)
    {
      del.val = del.next.val;
      del = del.next;
    }

    del.val = del.next.val;
    del.next = null;
  }

  /**
   * delete the duplicated nodes in a sorted linked list
   * @param ln
   * @return
   */
  public static LinkNode deleteDuplicated(LinkNode ln)
  {
    LinkNode curr = ln;

    while (ln != null)
    {
      if (ln.next != null && ln.val == ln.next.val)
      {
        ln.next = ln.next.next;
      }
      else
        ln = ln.next;
    }

    return curr;
  }

  /**
   * remove duplicates in an unsort linked list
   * @param ln
   * @return
   */
  public static LinkNode deleteDuplicatesInUnsorted(LinkNode ln)
  {
    LinkNode curr = ln;

    while (ln != null)
    {
      LinkNode currCopy = ln;
      LinkNode next = currCopy.next;

      while (next != null)
      {
        if (ln.val == next.val)
        {
          currCopy.next = currCopy.next.next;
        }
        else
          currCopy = currCopy.next;

        if (currCopy != null)
          next = currCopy.next;
        else
          next = null;
      }

      ln = ln.next;
    }

    return curr;
  }

  /**
   * delete last node
   * @param ln
   * @return
   */
  public static LinkNode deleteLastNode(LinkNode ln)
  {
    LinkNode curr = ln;

    if (ln == null || ln.next == null)
      return null;

    while (ln != null && ln.next != null)
    {
      if (ln.next.next == null)
      {
        ln.next = null;
      }

      ln = ln.next;
    }

    return curr;
  }
}
