package datastructure.link;

import sun.awt.image.ImageWatched;

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
    {
      return null;
    }

    LinkNode node = new LinkNode(0);
    LinkNode nodeHead = node;


    for(int i = 0 ; i < nums.length ; i++)
    {
      node.next = new LinkNode(nums[i]);
      node = node.next;
    }

    return nodeHead.next;

  }


}
