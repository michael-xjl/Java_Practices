package datastructure.link;

import sun.awt.image.ImageWatched;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * @author Michael Liu
 */
public class LinkGenerator
{
  public static LinkNode gen(int n, int bound)
  {

    LinkNode ln = new LinkNode(new Random().nextInt(10));

    LinkNode lnClone = ln;

    for(int i = 1; i< n ; i++)
    {
        LinkNode tmp = new LinkNode(new Random().nextInt(bound));
        ln.next = tmp;

        ln = ln.next;
    }

    return   lnClone;
  }


  public static LinkNode gen(int n)
  {
    return   gen(n,10);
  }

  public static LinkNode gen(int[] nums)
  {
    if(nums == null || nums.length == 0)
//      throw new IllegalArgumentException("nums is null");
    return null;

    LinkNode ln = new LinkNode(nums[0]);
    LinkNode curr = ln;

    for(int i = 1 ; i < nums.length ; i++)
    {
      ln.next = new LinkNode(nums[i]);
      ln = ln.next;
    }

    System.out.println(" - " + new Date() + "--: generate linked list : " + curr);
    return curr;
  }
}
