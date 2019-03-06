package datastructure.link;

/**
 * @author Michael Liu
 */
public class ReverseLink
{
  public static void main(String[] args)
  {
    System.out.println("------->recursion reverse 1");

    LinkNode head = createLinkNode();
    System.out.println(head);
    LinkNode reversedLN = reverse(head);
    System.out.println(reversedLN);
    System.out.println("original : " + head);

    System.out.println("------->recursion reverse 2");
    head = createLinkNode();
    System.out.println(head);
    LinkNode reversed2 = reverse2(head);
    System.out.println(reversed2);
    System.out.println("original : " + head);

    System.out.println("------->loop reverse");
    head = createLinkNode();
    System.out.println(head);
    System.out.println(reverseListByLoop(head));
  }

  private static LinkNode createLinkNode()
  {
    LinkNode head = new LinkNode(5);
    head.next = new LinkNode(4);
    head.next.next = new LinkNode(3);
    head.next.next.next = new LinkNode(2);
    head.next.next.next.next = new LinkNode(1);
    return head;
  }

  private static LinkNode reverse(LinkNode head)
  {
    if (head.next == null)
    {
      return head;
    }
    else
    {
      LinkNode nn = reverse(head.next);

      LinkNode nnHeadCopy = nn;

      while (nn.next != null)
      {
        nn = nn.next;
      }

      head.next = null;
      nn.next = head;

      return nnHeadCopy;
    }
  }


  public static LinkNode reverse2(LinkNode head) {

    if(head == null || head.next == null)
    {
      return head;
    }

    LinkNode ret = reverse2(head.next);
    head.next.next = head;
    head.next = null;

    return ret;

  }

  public static LinkNode reverseListByLoop(LinkNode head) {

    if(head == null || head.next == null)
      return head;

    LinkNode newHead = null;

    while(head != null)
    {
      LinkNode tmp = head.next;
      head.next = newHead;

      newHead = head;

      head = tmp;
    }

    return newHead;
  }
}
