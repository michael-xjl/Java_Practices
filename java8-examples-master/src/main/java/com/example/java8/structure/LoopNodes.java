package com.example.java8.structure;

public class LoopNodes {

	public void loop(Node node)
	{
		if(node == null) return;
		
		System.out.println(node.data);
		
		while(node.next != null)
		{
			node = node.next;
			System.out.println(node.data);
		}
	}
}
