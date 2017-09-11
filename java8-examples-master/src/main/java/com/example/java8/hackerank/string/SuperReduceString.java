package com.example.java8.hackerank.string;

public class SuperReduceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(super_reduced_string("aaabcc"));
		System.out.println(super_reduced_string("a"));
		System.out.println(super_reduced_string("cc"));
		System.out.println(super_reduced_string("ccdd"));
		System.out.println(super_reduced_string("ccddceeff"));
		
		System.out.println("methond 2 -------");
		System.out.println(super_reduced_string2("aaabcc"));
		System.out.println(super_reduced_string2("a"));
		System.out.println(super_reduced_string2("cc"));
		System.out.println(super_reduced_string2("ccdd"));
		System.out.println(super_reduced_string2("ccddceeff"));
	}
	
	//with StringBuffer
    static String super_reduced_string(String s){
        
    	StringBuffer sb = new StringBuffer(s);
    	for(int i = 0 ; i < sb.length() -1  ; i++)
    	{
    		if(sb.charAt(i) == sb.charAt(i+1))
    		{
    			sb.delete(i, i+2);
    			
    			i = i== 0 ? -1 : i-2; //important code

    		}
    	}
    	
    	
    	return sb.toString().isEmpty() ? "Empty String" : sb.toString();
    	
    }

    //without StringBuffer
    static String super_reduced_string2(String s){

    	for(int i = 1 ; i < s.length()   ; i++)
    	{
    		if(s.charAt(i) == s.charAt(i-1))
    		{
    			s = s.substring(0,i-1) + s.substring(i+1);
    			i = i== 1 ? 0  : i - 2;//important code
    		}
    		
    	}
    	
    	
    	return s.isEmpty() ? "Empty String" : s;
    	
    }
}
