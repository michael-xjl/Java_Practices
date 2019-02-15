package datastructure.link;

import sun.awt.image.ImageWatched;

import java.util.Random;

/**
 * @author Michael Liu
 */
public class LinkGenerator
{
  public static LinkNode gen(int n)
  {

    LinkNode ln = new LinkNode(new Random().nextInt(10));

    LinkNode lnClone = ln;

    for(int i = 1; i< n ; i++)
    {
        LinkNode tmp = new LinkNode(new Random().nextInt(10));
        ln.next = tmp;

        ln = ln.next;
    }


    return   lnClone;
  }
}
