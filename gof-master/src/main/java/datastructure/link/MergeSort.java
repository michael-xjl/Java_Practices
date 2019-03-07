package datastructure.link;

/**
 * @author Michael Liu
 */
public class MergeSort
{

  public static void main(String[] args)
  {
    LinkNode head = LinkGenerator.gen(new int[]{2,5,7,12,8,4,30});
    LinkNode mid = getMiddle(head);
    System.out.println(mid);
  }
  public static LinkNode sortedMerge(LinkNode a, LinkNode b)
  {
    LinkNode result = null;

    if (a == null)
      return b;
    if (b == null)
      return a;

    if (a.val <= b.val)
    {
      result = a;
      result.next = sortedMerge(a.next, b);
    }
    else
    {
      result = b;
      result.next = sortedMerge(a, b.next);
    }
    return result;
  }

  public static LinkNode getMiddle(LinkNode h)
  {
    if (h == null)
      return h;

    LinkNode fastptr = h;
    LinkNode slowptr = h;

    while (fastptr != null && fastptr.next != null)
    {
      slowptr = slowptr.next;
      fastptr = fastptr.next.next;
    }
    return slowptr;
  }
}
