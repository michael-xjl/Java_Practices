package com.example.java8;

import static org.junit.Assert.*;

import org.junit.Test;

public class StreamsTest {

	@Test
	public void testIntegerArrayToIntArray() {
		Integer[] bigArr = new Integer[]{1,2,3};
		assertArrayEquals(new int[]{1,2,3}, Streams.integerArrayToIntArray(bigArr));
	}
	
	@Test
	public void testIntArrayToIntegerArray() {
		Integer[] bigArr = new Integer[]{1,2,3};
		assertArrayEquals(bigArr, Streams.intArrayToIntegerArray(new int[]{1,2,3}));
	}

}
