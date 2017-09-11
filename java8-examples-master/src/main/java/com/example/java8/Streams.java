package com.example.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Streams {

	
	/*（*
	 * Convert Integer[] to int[]
	 */
	public static int[] integerArrayToIntArray(Integer[] bigArr){
		return Arrays.asList(bigArr).stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static Integer[] intArrayToIntegerArray(int[] smallArr){
		
		return IntStream.of(smallArr).boxed().toArray(Integer[]::new);
		
	}	
}
