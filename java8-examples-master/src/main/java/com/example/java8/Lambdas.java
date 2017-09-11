/**
 * 
 */
package com.example.java8;

import java.util.*;
import java.util.function.Function;
/**
 * @author xjliu
 *
 */
interface Grassy { String move();};

public class Lambdas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	void everyonePlay(boolean baby)
	{
//		/effecitvely final
		final String approach = "good";
//		approach = "ok";
		
		if ( this instanceof Object)
		
		Function<List<String>, String> ex1 = x -> x.get(0);
		
		play(() -> "ok");
		play(() -> {return "ok";});
		play(()-> approach);
		
		
		
	}
	
	void play(Grassy g)
	{
		System.out.println(g.move());
	}

}
