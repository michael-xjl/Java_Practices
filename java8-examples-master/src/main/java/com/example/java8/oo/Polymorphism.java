package com.example.java8.oo;

public class Polymorphism {

	public static void main(String[] args) {
		A c = new B();
		c.a();
	}

}

class A
{
	public void a()
	{
		
		System.out.println("A.a()");
	}
	
	public static void s()
	{
		System.out.println("A.s()");
	}
}

class B extends A
{
	@Override
	public void a()
	{
		System.out.println("B.a()");
	}
	
	public static void s()
	{
		System.out.println("B.s()");
	}
}
