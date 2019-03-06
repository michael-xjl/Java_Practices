package datastructure.link;

/**
 * @author Michael Liu
 */
public class SwapNodes
{
  public static void main(String[] args)
  {
    System.out.println(swapNodes(LinkGenerator.gen(new int[]{5,7,9,10,20,8,11}), 9,11));
  }

  private static LinkNode swapNodes(LinkNode ln, int m, int n)
  {

    if(ln == null || m == n)
      return ln;

    LinkNode curr = ln;

    LinkNode mPreNode = null, mCurNode = ln;


      while(mCurNode != null && mCurNode.val != m)
      {

        mPreNode = mCurNode
        ln = ln.next;
      }

    LinkNode nPreNode = null , nCurNode = ln;

    if (ln.val == n)
    {
      nCurNode = ln;
    }
    else
    {
      while (ln != null)
      {
        if (ln.next != null && ln.next.val == n)
        {
          nPreNode = ln;
          break;
        }

        ln = ln.next;
      }
    }

    if(mPreNode != null && nPreNode != null)
    {

      LinkNode mTmp = mPreNode.next;
      LinkNode nTmp = nPreNode.next;



      LinkNode mNextTmp = mTmp.next;
      mTmp.next = null;

      mPreNode.next = nTmp;

      nPreNode.next = mTmp;

      LinkNode nNextTmp = nTmp.next;
      nNextTmp.next = null;


      mPreNode.next.next = mNextTmp;
      nPreNode.next.next = nNextTmp;
    }
    else if(mCurNode != null && nPreNode != null)
    {
      LinkNode nTmp = nPreNode.next;
      nTmp.next = mCurNode.next;
      curr = nTmp;
    }
    else if(nCurNode != null && mPreNode != null)
    {
      LinkNode mTmp = mPreNode.next;
      mTmp.next = nCurNode.next;
      curr = mTmp;
    }


    return curr;
  }


  private static LinkNode swapNodes2(LinkNode head, int x, int y)
  {

    if(head == null || x == y)
      return head;

    LinkNode preX = null, curX = head;
    while(curX != null && curX.val != x)
    {
      preX = curX;
      curX = curX.next;
    }

    LinkNode preY = null , curY = head;
    while(curY != null && curY.val != y)
    {
      preY = curY;
      curY = curY.next;
    }


    // If either x or y is not present, nothing to do
    if (curX == null || curY == null)
      return head;

    // If x is not head of linked list
    if (preX != null)
      preX.next = curY;
    else //make y the new head
      head = curY;

    // If y is not head of linked list
    if (preY != null)
      preY.next = curX;
    else //make y the new head
      head = curX;

    // Swap next pointers
    LinkNode temp = curX.next;
    curX.next = curY.next;
    curY.next = temp;

    return head;
  }
}
