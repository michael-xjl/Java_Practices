package com.example.java8.functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
Given a list of integers, return a list where each integer is multiplied by 2.

doubling([1, 2, 3]) → [2, 4, 6]
doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
doubling([]) → []
	 * @param nums
	 * @return
	 */
	public List<Integer> doubling(List<Integer> nums) {
		  return nums.stream().map(i -> i*2).collect(Collectors.toList());
		  "".replaceAll(regex, replacement)
//		   nums.replaceAll(i -> i*2);
	}

}
