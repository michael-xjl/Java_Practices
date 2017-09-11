package com.example.java8.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {

		IntStream.iterate(1, p -> p+1).parallel().limit(30).forEach(System.out::println);
		System.out.println();
		IntStream.iterate(1, p -> p+1).limit(30).forEach(System.out::println);
		System.out.println();
		IntStream.iterate(1, p -> p+1).limit(30).parallel().forEach(System.out::println);		
		
		System.out.println();
		Stream<Integer> sInteger = IntStream.iterate(1, p -> p+1).limit(30).mapToObj(i -> new Integer(i));
		IntStream sInt = sInteger.mapToInt(i -> i.intValue());

	}

}
