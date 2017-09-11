package com.example.java8.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> foodData = new HashMap<String, Object>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		for(String key: foodData.keySet())
		{
		   //foodData.remove(key);
			
		}
		
		Map<String, Object> foodData2 = new ConcurrentHashMap<>();
		foodData2.put("penguin", 1);
		foodData2.put("flamingo", 2);
		System.out.println(foodData2);
		for(String key: foodData2.keySet())
		{
		   foodData2.remove(key);
			
		}
		System.out.println(foodData2);
		
		Set<Map.Entry<String, Object>> set  = foodData.entrySet();
		Iterator<Entry<String, Object>> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(foodData);
			Entry<String, Object> entry = iterator.next();
			
			System.out.println(entry.getKey() + "|" + entry.getValue());
			iterator.remove();
		}
		System.out.println(foodData);
	}

}
