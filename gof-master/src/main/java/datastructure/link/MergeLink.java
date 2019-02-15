package datastructure.link;

/**
 * @author Michael Liu
 */
public class MergeLink
{
  public static void main(String[] args)
  {

    LinkNode d1 = LinkGenerator.gen(10);
    System.out.println(d1);

    LinkNode d2 = LinkGenerator.gen(10);
    System.out.println(d2);

    System.out.println(mergeNode(d1,d2));

  }

  public static LinkNode mergeNode(LinkNode l1, LinkNode l2)
  {
    LinkNode nn = new LinkNode(0);
    LinkNode l1copy = nn;

    while(l1.next != null)
    {
        nn.next = l1;
      nn = nn.next;
      nn.next = l2;
      nn = nn.next;

        l1 = l1.next;
        l2 = l2.next;
    }

    return l1copy;


  }

}
