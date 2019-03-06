package datastructure.link;

/**
 * @author Michael Liu
 */
public class MergeLink
{
  public static void main(String[] args)
  {

    LinkNode d1 = LinkGenerator.gen(10,50);
    System.out.println(d1);

    LinkNode d2 = LinkGenerator.gen(10, 30);
    System.out.println(d2);

//    System.out.println("");
//    System.out.println(mergeNode(d1,d2));
//    System.out.println(d1);
//    System.out.println(d2);

    System.out.println("");
    System.out.println(mergeNode2(d1,d2));
    System.out.println(d1);
    System.out.println(d2);
  }


  public static LinkNode mergeNode(LinkNode l1, LinkNode l2)
  {

    if(l1 == null) return l2;
    if(l2 == null) return l1;

    LinkNode dummy = l1;

    while(l1.next != null)
    {
      l1 = l1.next;
    }

    l1.next = l2;

    return dummy;
    //l1 is changed

  }

  //l1 and l2 are readonly
  public static LinkNode mergeNode2(LinkNode l1, LinkNode l2)
  {
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    LinkNode dummy = new LinkNode(l1.val);
    LinkNode dummyHead = dummy;

    while(l1.next != null)
    {
      l1 = l1.next;
      dummy.next = new LinkNode(l1.val);
      dummy = dummy.next;
    }

    dummy.next = l2;

    return dummyHead;
  }

}
