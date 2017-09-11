package com.example.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqValuesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {1,23,2,2,1,5,8,5,8};
		
		System.out.println(findUniqInPairs(intArray));
		System.out.println(findUniqInPairs2(intArray));
		System.out.println(findUniqInPairs3(intArray));
		
	}
	
	/**
	 * {1,23,2,2,1,1,5,8,5,8} --> 23
	 * @param intArrays
	 * @return
	 */
	public static int findUniqInPairs(int[] arr)
	{
		
	    Arrays.sort(arr);
	    System.out.println(Arrays.toString(arr));
	    for (int i = 0, max = arr.length - 1; i < max; i += 2)
	        if (arr[i] != arr[i + 1])
	            return arr[i];
	    return arr[arr.length - 1]; // Single element is the last
		
	}
	
	public static int findUniqInPairs2(int[] array)
	{
		
	    Set<Integer> set = new HashSet<Integer>();

	    for (int item : array) {
	        if (!set.remove(item)) {
	            set.add(item);
	        }
	    }       

	    assert set.size() == 1;

	    return set.iterator().next();
		
	}	
	
	
	public static int findUniqInPairs3(int[] array)
	{
		int result = 0;
		for(int a: array)
			result ^= a;
		return result;

		
	}	
	

}
