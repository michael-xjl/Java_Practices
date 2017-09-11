package com.example.java8.structure;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

interface MultipleMapIfc<K,V> {
	
	List get(K key);

	void put(K key,V value);
	
	Set<K> keySet();
}


public class MultipleMap<K, V> implements MultipleMapIfc<K, V> 
{
	Map<K, LinkedList<V>> map = new LinkedHashMap<>();
	
	@Override
	public List get(K key) {
		return map.get(key);
	}

	@Override
	public void put(K key, V value) {
		
		if(map.containsKey(key))
		{
			map.get(key).add(value);
		}
		else
		{
			LinkedList<V> list = new LinkedList<>();
			list.add(value);
			map.put(key, list);
		}
		
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}
}