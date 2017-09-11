package com.example.java8;

import java.math.BigDecimal;
import java.util.Arrays;

public class Numbers {
	public static void main(String[] args)
	{
        BigDecimal value = new BigDecimal("2.0").subtract(new BigDecimal("1.1"));
        System.out.println("value = " + value);
        
        Numbers.NumOfArraysQuestion();
        Numbers.StringCompare();
	}
	
	public static void NumOfArraysQuestion()
	{
        System.out.println("************** Integers");
        Integer[] integers = new Integer[]{1, 2, 3};
        System.out.println(Arrays.asList(integers));
        System.out.println(Arrays.asList(integers).size());

        System.out.println("************** Integers as Objects ref");
        Object[] objects = new Integer[]{1, 2, 3};
        System.out.println(Arrays.asList(objects));
        System.out.println(Arrays.asList(objects).size());

        System.out.println("************** Strings");
        String[] strings = {"1", "2", "3"};
        System.out.println(Arrays.asList(strings));
        System.out.println(Arrays.asList(strings).size());

        System.out.println("************** int");
        Object ints = (new int[]{1, 2, 3});
        System.out.println(Arrays.asList(ints));
        System.out.println(Arrays.asList(ints).size());
	}
	
	
	public static void StringCompare()
	{
        // compare 1
        String x = "java";
        String y = "java";
        if (x == y) {
            System.out.println("they are equal");
        } else {
            System.out.println("they are NOT equal");
        }

        // compare 2
        x = x.toUpperCase();
        y = y.toUpperCase();
        if (x == y) {
            System.out.println("they are equal");
        } else {
            System.out.println("they are NOT equal");
        }

        // compare 3
        x = x.toUpperCase().intern();
        y = y.toUpperCase().intern();
        if (x == y) {
            System.out.println("they are equal");
        } else {
            System.out.println("they are NOT equal");
        }
	}
}
