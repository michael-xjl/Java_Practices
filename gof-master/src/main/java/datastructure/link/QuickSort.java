package datastructure.link;

/**
 * @author Michael Liu
 */
public class QuickSort
{

  public static void main(String[] args)
  {
    System.out.println(quickSort(LinkGenerator.gen(10)));
  }
  public static LinkNode quickSort(LinkNode LinkNode)
  {
    LinkNode = quickSortRec(LinkNode, getTail(LinkNode));

    return LinkNode;
  }

  public static LinkNode getTail(LinkNode n)
  {
    while (n != null && n.next != null)
      n = n.next;

    return n;
  }

  static class Res
  {
    LinkNode newHead = null, newEnd = null;
  }

  public static LinkNode quickSortRec(LinkNode head, LinkNode last)
  {
    if (head == null || head == last)
      return head;

    Res r = new Res();
    Res s = new Res();
    LinkNode pivot = partition(head, last, r, s);

    if (r.newHead != pivot)
    {
      LinkNode tmp = r.newHead;
      while (tmp.next != pivot)
        tmp = tmp.next;
      tmp.next = null;

      r.newHead = quickSortRec(r.newHead, tmp);
      tmp = getTail(r.newHead);
      tmp.next = pivot;

    }
    pivot.next = quickSortRec(pivot.next, s.newEnd);
    return r.newHead;
  }

  public static LinkNode partition(LinkNode head, LinkNode last, Res r, Res s)
  {
    LinkNode pivot = last;
    LinkNode prev = null, cur = head, tail = pivot;

    while (cur != pivot)
    {
      if (cur.val < pivot.val)
      {

        if (r.newHead == null)
          r.newHead = cur;

        prev = cur;
        cur = cur.next;
      }
      else
      {

        if (prev != null)
          prev.next = cur.next;
        LinkNode tmp = cur.next;
        cur.next = null;
        tail.next = cur;
        tail = cur;
        cur = tmp;
      }
    }

    if (r.newHead == null)
      r.newHead = pivot;

    s.newEnd = tail;

    return pivot;
  }
}
