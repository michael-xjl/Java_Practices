package datastructure.link;

/**
 * @author Michael Liu
 */
public class OddEven
{
  public static void main(String[] args)
  {

    LinkNode ln = LinkGenerator.gen(new int[]{1,2,3,4,5,6,7,8,9});
    System.out.println(ln);

    System.out.println(oddEven(ln));
  }

  /***
   *
   *
   *
   * ln : 1 -> 2 -> 3 -> 4 - > 5 ->6 ->7 ->8 ->9
   * odd: 1 -> 2 -> 3 -> 4 - > 5 ->6 ->7 ->8 ->9
   * eve: 2 -> 3 -> 4 - > 5 ->6 ->7 ->8 ->9
   *
   * -->
   * odd.next = even.next
   * odd : 1 -> 3 -> 4 - > 5 ->6 ->7 ->8 ->9
   * odd = odd.next
   * odd : 3 -> 4 - > 5 ->6 ->7 ->8 ->9
   *
   * even.next = odd.next
   * 2 -> 4 - > 5 ->6 ->7 ->8 ->9
   * even = even.next
   * even: 4 - > 5 ->6 ->7 ->8 ->9
   *
   *
   * @param ln
   * @return
   */

  private static LinkNode oddEven(LinkNode ln)
  {
    if(ln == null || ln.next == null)
      return ln;

    LinkNode odd = ln, even = ln.next, oddHead = even;

    while(even != null && even.next != null)
    {
      odd.next = even.next;
      odd = odd.next;

      even.next = odd.next;
      even = even.next;
    }

    odd.next = oddHead;

    return ln;

  }
}
