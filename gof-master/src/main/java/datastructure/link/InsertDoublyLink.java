package datastructure.link;

/**
 * @author Michael Liu
 */
public class InsertDoublyLink
{

  public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {



    if(pos == 1)
    {
      DoublyLinkedNode nh = new DoublyLinkedNode(data);
      nh.next = head;
      if(head != null)
        head.prev = nh;

      return nh;
    }


    int index = 1;
    DoublyLinkedNode curr = head, prev = curr;

    while(curr != null)
    {
      prev = curr;
      curr = curr.next;
      index ++;

      if(pos == index)
      {
        DoublyLinkedNode ih = new DoublyLinkedNode(data);

        prev.next = ih;
        ih.prev = prev;

        ih.next = curr;
        if(curr != null) curr.prev = ih;
      }
    }

    return head;





  }}
