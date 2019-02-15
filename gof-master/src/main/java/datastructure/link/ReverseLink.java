package datastructure.link;

/**
 * @author Michael Liu
 */
public class ReverseLink
{
  public static void main(String[] args)
  {
    LinkNode head = new LinkNode(5);
    head.next = new LinkNode(4);
    head.next.next = new LinkNode(3);
    head.next.next.next = new LinkNode(2);
    head.next.next.next.next = new LinkNode(1);

    reverse(head);
  }

  private static LinkNode reverse(LinkNode head)
  {
    if(head.next == null)
    {
      return new LinkNode(head.val);

    }
    else
    {
      LinkNode nn = reverse( head.next);

      LinkNode next = nn.next;

      if(next == null)
      {
        next = new LinkNode(head.val);
      }
      nn.next = new LinkNode(head.val);

      return nn.next;
    }

  }
}
