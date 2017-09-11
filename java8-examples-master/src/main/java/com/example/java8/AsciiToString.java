package com.example.java8;

 class AsciiToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       int num[] = {65, 120, 98, 75, 115};
	        String str =null;
	        for(int i: num){
	            str = Character.toString((char)i);
	            
	            System.out.println(String.valueOf((char)i));
	        }
	        
	        
	        String asciiStr = "AxbKs";
	        char[] ca = asciiStr.toCharArray();
	        for(char c : ca)
	        	System.out.println(c);
	        for(char c : ca)
	        	System.out.println((int)c);
	}

}
