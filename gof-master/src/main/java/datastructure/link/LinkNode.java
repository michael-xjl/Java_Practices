package datastructure.link;

/**
 * @author Michael Liu
 */
public class LinkNode
{
  public int val;
  public LinkNode next;

  public LinkNode(int x)
  {
    val = x;
  }


  public LinkNode(int x, LinkNode next)
  {
    this.val = x;
    this.next = next;
  }

  @Override public String toString()
  {

    StringBuilder sb = new StringBuilder();

    sb.append("[");

    final String nodesVal = getNodesVal(this);

    sb.append(nodesVal);

    sb.append("]");

    return sb.toString();
  }
  
  private String getNodesVal(LinkNode n)
  {
    
    if(n.next == null)
       return String.valueOf(n.val);

    return String.valueOf(n.val) + "," + getNodesVal(n.next);
  }
}
