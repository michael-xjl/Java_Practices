package com.example.java8.innerclass;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Outer1 {
	private int x = 5;
	public static int STATIC_INT = 5;
	
	public static void staticMethod()
	{
		STATIC_INT++;
		System.out.println(STATIC_INT);
//		throw new RuntimeException();
	}
	
	public void hasInnerMethod()
	{
		class Inner2{
			private String xx = "";
			public void print() {
				System.out.println("print() in Inner2 - has InnerMethod()");
				System.out.println( x + " - has InnerMethod()");
				x++;
				System.out.println( x + " - has InnerMethod()");
			}
		}
		
		Inner2 i2 = new Inner2();
		i2.print();
	}
	
	
	
	protected class Inner1{
		//can't declare static method in non-static class and no top-level class
//		public static void canStaticMethod(){};
		public void go() {System.out.println(x);}
	}
	
	public static class Inner3{
		public static String staticVairable1 = "static String";
		public  String  vairable2 = " no static String";
		public void go3() {System.out.println("go() -- static class Inner3 : " + staticVairable1 + vairable2);}
		
	}
	
	class ExtendInner4 extends Outer1
	{

			@Override
			//Overridden methods can throw Exceptions, so long as the method being overridden also throws the same Exceptions. You can't introduce new Exceptions.but RuntimeException is 
			//okay
			public void hasInnerMethod() throws RuntimeException
//			public void hasInnerMethod() throws Exception
			{
				
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer1 o1 = new Outer1();
		Inner1 i1 = new Outer1().new Inner1();
		
		//don't access a static method by a instance reference
		o1.staticMethod();
		Outer1.staticMethod();
		
		o1.hasInnerMethod();
		i1.go();
		
		
		
		Inner3 i3 = new Inner3();
		i3.go3();
		System.out.println(Inner3.staticVairable1);
		System.out.println(i3.staticVairable1);
		
		System.out.println(i3.vairable2);


	}

}

class Outer2
{
	String i3 = Outer1.Inner3.staticVairable1;
	Outer1.Inner1 i1 = new Outer1().new Inner1();
}

interface Ifc
{
	static void methond1(){System.out.println("static methond in Ifc");
	
	 default void defaultMethod(){};
	};
}
