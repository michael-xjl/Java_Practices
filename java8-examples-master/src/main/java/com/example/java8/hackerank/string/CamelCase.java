package com.example.java8.hackerank.string;

public class CamelCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWords("thisWorldIsBeauterful"));
	}

	public static int countWords(String s)
	{
		int i = 0;
		if( s == null || s.isEmpty())
			return i;
		
		i++;
		for(int j = 0 ; j < s.length() ; j++)
		{
			if(Character.isUpperCase(s.charAt(j)))
				i++;
		}
		return i;
		
			
	}
}
