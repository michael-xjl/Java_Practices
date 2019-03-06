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

    System.out.println(deleteNodeNthEnd(dbyend,3));

     dbyend = LinkGenerator.gen(new int[]{1,2,3,4,5,6});
    System.out.println(dbyend);
    deleteCurrentNode(dbyend.next.next);
    System.out.println(dbyend);


  }

  public static LinkNode deleteNodeByVal(LinkNode head, int val)
  {

    if(head == null)
      return null;
    
    LinkNode  help =  head;

    while(help.next != null)
    {
      if(help.next.val == val)
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


    for(int i = 0 ; i < index; i++)
    {
        fast = fast.next;
    }

    while(fast.next != null)
    {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;

  }

  public static void deleteCurrentNode(LinkNode del)
  {
    while(del.next.next != null)
    {
      del.val = del.next.val;
      del = del.next;
    }

    del.val = del.next.val;
    del.next = null;
  }
}
