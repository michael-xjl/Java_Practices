package datastructure.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Michael Liu
 */
public class SortByValue
{
  public static void main(String[] args)
  {
    treeMap();

    Map<Integer, String> hm = new HashMap<>();
    hm.put(3,"456");
    hm.put(1,"9123");
    hm.put(2,"456");


    System.out.println(hm);

    System.out.println(sortByValue(hm));
  }

  public static void treeMap()
  {
    TreeMap<Integer,String> tm = new TreeMap<>();
    tm.put(3,"789");
    tm.put(1,"123");
    tm.put(2,"456");
    System.out.println(tm);
  }

  public static <K extends Comparable<? super K>,V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
  {
    List<Map.Entry<K,V>> list = new ArrayList<>(map.entrySet());

//    Collections.sort(list, Map.Entry.comparingByValue());
    list.sort(Map.Entry.comparingByKey());

    Map<K,V> result = new LinkedHashMap<>();
    for(Map.Entry<K,V> entry : list)
    {
      result.put(entry.getKey(), entry.getValue());
    }

    return result;
  }

}
