package com.example.java8.structure;

import java.util.Stack;

public class LinkedListNode {
	/**
	 * insert the node to the tail , and return the head node;
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	public Node insertNodeToTail(Node head, int data) {
		if (head == null) {
			head = new Node();
			head.data = data;
			head.next = null;
			return head;
		} else {
			Node walkNode = head;
			while (walkNode.next != null) {
				walkNode = walkNode.next;
			}

			Node tailNode = new Node();
			tailNode.data = data;
			tailNode.next = null;

			walkNode.next = tailNode;

			return head;
		}
	}

	public Node insertNodeToHead(Node head, int data) {
		if (head == null) {
			head = new Node();
			head.data = data;
			head.next = null;
			return head;
		} else {

			Node tailNode = new Node();
			tailNode.data = data;
			tailNode.next = head;

			return tailNode;
		}
	}

	Node InsertNth(Node head, int data, int position) {
		if (head == null) {
			head = new Node();
			head.data = data;
			head.next = null;
			return head;
		} else {
			Node tailNode = new Node();
			tailNode.data = data;
			tailNode.next = null;

			if (position == 0) {
				tailNode.next = head;
				return tailNode;
			} else {
				int i = 0;
				Node walkNode = head;
				while (walkNode.next != null) {
					i++;

					if (i == position) {
						tailNode.next = walkNode.next;
						walkNode.next = tailNode;
						break;
					}
					walkNode = walkNode.next;

				}

				return head;
			}

		}

	}
	/*
	 * Delete Node at a given position in a linked list head pointer input could
	 * be NULL as well for empty list Node is defined as class Node { int data;
	 * Node next; }
	 */
	// This is a "method-only" submission.
	// You only need to complete this method.

	Node Delete(Node head, int position) {
		if (head == null)
			return null;

		Node currentNode = head;
		if (position == 0) {
			return head.next;
		} else {
			int i = 1; //@@@important!!!!@@@
			while (currentNode.next != null) {
                
				if (i == position) {
					currentNode.next = currentNode.next.next;
                    break;
				}
				currentNode = currentNode.next;
                i++;
                
			}
		}
		
		return head;

	}
	
	
	/*
	  Print elements of a linked list in reverse order 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	    // This is a "method-only" submission. 
	    // You only need to complete this method. 

	void reversePrint(Node head) {

		if(head == null) return;
		
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while(head.next != null)
		{
			head = head.next;
			stack.push(head);
		}

		while(!stack.isEmpty())
		{
			System.out.println(stack.pop().data);
		}

		
		
		

	}
	
	/* recursion **/
	void reversePrintRecursion(Node head) {
		if(head != null)
		{
			reversePrintRecursion(head.next);
			System.out.println(head.data);
		}

	}	
	
	
	void print(Node head) {
		if(head != null)
		{
			System.out.println(head.data);
			while(head.next != null)
			{
				head = head.next;
				System.out.println(head.data);
			}
		}
	}
	
	void printRecursion(Node head) {
		if(head != null)
		{
			System.out.println(head.data);
			printRecursion(head.next);
		}
	}
	
	
	/*
	  Reverse a linked list and return pointer to the head
	  The input list will have at least one element  
	  Node is defined as  
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	    // This is a "method-only" submission. 
	    // You only need to complete this method. 
	Node Reverse(Node head) {
		return null;
		

	}
	


}
