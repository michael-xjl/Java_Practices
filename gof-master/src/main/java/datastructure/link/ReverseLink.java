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
     return  LinkGenerator.gen(new int[]{5,4,3,2,1});

  }

  public static LinkNode reverse(LinkNode head)
  {

    // base case , null is reached to tail
    if (head.next == null)
    {
      return new LinkNode(head.val);
    }
    else
    {
      LinkNode nn = reverse(head.next);

      LinkNode nnHeadCopy = nn;

      /*********************************/
      // keep the head, always return the head *****
      LinkNode headCopy = nn;

      // go the tail
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

//    if(head == null || head.next == null)
//      return head;
//
//    LinkNode newHead = null;
//
//    while(head != null)
//    {
//      LinkNode tmp = head.next;
//      head.next = newHead;
//
//      newHead = head;
//
//      head = tmp;
//      /*********************************/
//
//      // append current node to tail
//      nn.next = new LinkNode(head.val);
//
//      return headCopy;
    return null;
  }

  public static LinkNode reverse3(LinkNode head)
  {
    // base case , null is reached to tail
    if (head.next == null)
    {
      return head;
    }
    else
    {
      LinkNode nn = reverse(head.next);

      /*********************************/
      // keep the head, always return the head *****
      LinkNode headCopy = nn;

      // go the tail
      while (nn.next != null)
      {
        nn = nn.next;
      }
      /*********************************/

      // append current node to tail
      nn.next = head;

      return headCopy;
    }
  }

}
