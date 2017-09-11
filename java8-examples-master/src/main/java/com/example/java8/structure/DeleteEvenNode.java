package com.example.java8.structure;


public class DeleteEvenNode {

	
	/** delete node which data is even , and return the head Node; **/
	public  Node deleteEvenNode(Node head)
	{
		Node pre = head;
		if(head == null) return null;
		
		if(pre.next != null)
		{
		
			if(isEven(pre.next))
				pre.next = pre.next.next;
			else
				pre = pre.next;
		}
		
		//at this point, pre is the tail node
		
		if(isEven(head))
			head = head.next;
		
		return head;
	}
	
	private boolean isEven(Node node)
	{
		return node.data % 2 == 0 ;
	}
	
}

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		
	}
	
	Node()
	{
		
	}
}
