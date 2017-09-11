package com.example.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SquarBigNums {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquarBigNums.square(new int[]{2,3,1,2});
	}
	
	/**
	 * sourceArray = {1,2,3,5,6,7};
	 * represents num: 765321
	 * @param souceArray
	 * @return
	 */
	public static int[] square(int[] souceArray)
	{
		List<Integer> list =  new LinkedList<>();
		
		int next = 0;
		for(int i = souceArray.length -1; i >= 0 ; i--)
		{
			int n = souceArray[i] * souceArray[i];
			
			n += next;
			
			if(n >= 10)
			{
				next = n/10;
				list.add(n%10);
			}
			else
			{
				next =  0;
				list.add(n);
			}
			
		}
		
		if(next > 0)
			list.add(next);
		
		Collections.reverse(list);
		list.forEach(System.out::println);
		
		return null;
			
		

	}

}
