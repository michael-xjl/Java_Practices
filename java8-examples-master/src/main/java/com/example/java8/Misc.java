package com.example.java8;

public class Misc {
	private static boolean heatWave = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      boolean heatWave = false;
	      System.out.print(heatWave);
	      System.out.print(Misc.heatWave);
	      
	      new Misc().printColor();

	}
	
	private void printColor()
	{
		System.out.println("private method");
	}

}


class InnerClass
{
	private void printColor()
	{
		System.out.println("InnerClass private method");
	}

}