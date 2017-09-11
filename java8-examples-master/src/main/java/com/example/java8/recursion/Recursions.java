package com.example.java8.recursion;

import java.util.Arrays;
import java.util.List;

public class Recursions {
	
	public static void main(String[] args)
	{
		Recursions r = new Recursions();
		System.out.println(r.count7(717));
	}

	/**
	 * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).

factorial(1) → 1
factorial(2) → 2
factorial(3) → 6
	 */
	
	public int factorial(int n) {
		  
		if(n == 1)
			return 1;
		
		return n*factorial(n-1);
	}
	/**
	 * 
The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.

fibonacci(0) → 0
fibonacci(1) → 1
fibonacci(2) → 1
	 * @param n
	 * @return
	 */
	
	public int fibonacci(int n) {
		  if(n == 0) return 0;
		  if(n == 1 || n == 2) return 1;
		  
		  return fibonacci(n-1) + fibonacci(n - 2);
	}

/**
 * 
 * !!!important
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
 * @param bunnies
 * @return
 */
	public int bunnyEars2(int bunnies) {
			
	  	if(bunnies == 0) return 0;
		
			int mode = 2;
			if(bunnies % 2 == 0) 
	      mode = 3;
			
			return mode + bunnyEars2(bunnies-1);

	}


	/**
	 * 
We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.

triangle(0) → 0
triangle(1) → 1
triangle(2) → 3
	 * @param rows
	 * @return
	 */
	
	public int triangle(int rows) {
		  if(rows == 0) return 0;
		  
		  return rows + triangle(rows - 1);
		  
	}
	
	/**
	 * Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

sumDigits(126) → 9
sumDigits(49) → 13
sumDigits(12) → 3
	 * @param n
	 * @return
	 */
	public int sumDigits(int n) {
		if(n < 10) return n;
		
		return n%10 + sumDigits(n/10);
		
		
		//with loop
		/**
	       int count  = 0;
	       if(n < 10)
	        return n;
	       while(n>0)
	       {
	         count +=  n%10;
	         n /= 10;
	       }
	       
	       return count;
	       **/
	  
	}
	
	/**
	 * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

count7(717) → 2
count7(7) → 1
count7(123) → 0

**/
	public int count7(int n) {
	    int c = 0;
	    if( n < 10 )
	    {
	        if(n == 7)
	          c = 1;
	        
	        return c;
	    }
	    else
	    {
	      if(n%10 == 7)
	        c = 1;
	    }
	        
	   return c + count7(n/10);
		
		//return (int)String.valueOf(n).chars().peek(c->System.out.println(Character.getNumericValue(c))).filter(c -> Character.getNumericValue(c) == 7).count();
		
	}



}
