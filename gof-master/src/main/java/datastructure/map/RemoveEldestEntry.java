package datastructure.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * RemoveEldestEntry method is useful when implement LRU cache (LRU: evicts least recently used items)
 *
 * MRU cache : Most Recently Used
 * LFU: Least Frequently Used
 *
 * @author Michael Liu
 */
public class RemoveEldestEntry
{
  public static void main(String[] args)
  {

    int max = 5;
    Map<Integer,String> m = new LinkedHashMap()
    {
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
          return size() > max;
        }
    };


    m.put(1,"is 1");
    m.put(2,"is 2");
    m.put(3,"is 3");
    m.put(4,"is 4");
    m.put(5,"is 5");
    m.put(6,"is 6");

    //will output : {2=is 2, 3=is 3, 4=is 4, 5=is 5, 6=is 6}, the eldest one is removed

    System.out.println(m);
  }
}
