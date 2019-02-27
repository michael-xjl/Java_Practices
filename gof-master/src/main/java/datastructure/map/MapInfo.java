package datastructure.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Liu
 */
public class MapInfo
{

  public static void main(String[] args)
  {
    Map<Integer, String> hm = new HashMap<>();
    hm.put(3,"456");
    hm.put(1,"9123");
    hm.put(2,"456");

    System.out.println(hm);

    int i = 50;
    System.out.println(i>>1); /** i/2 **/
    System.out.println(i<<2); // i*2^2
    System.out.println(1<<2); // 1*2^2

    System.out.println(3^2); //1


    hm.put(null,null);
    hm.put(1,null);
    System.out.println(hm);
    /**{null=null, 1=null, 2=456, 3=456}**
     * as null is allowed in map, when compare two maps if they are equal, need to consider such boundary
     */

    /***********************************************
     *  Map collision
     *
     *  KeyObject(i): when i < 10, will have same hash code :5
     */
    /** even set the initial capacity to 50, it will convert to 2 power , 64 , without initial capacity argument, the value is 1>>4 (aka 16) **/
    /** threshold 10 will decide when to resize the underlying array<Node> table **/

    Map<KeyObject, String> myMap = new HashMap<>(50,10);
    myMap.put(new KeyObject(5),"this is 5"); //initialCapacity & hashcode (aka hashCode % initialCapacity) will decide the array
    myMap.put(new KeyObject(8),"this is 8");
    myMap.put(new KeyObject(8),"this is 8");
    myMap.put(new KeyObject(8),"this is 8");
    myMap.put(new KeyObject(9),"this is 9");
    myMap.put(new KeyObject(26),"this is 26");
    myMap.put(new KeyObject(35),"this is 35");
    myMap.put(null,"this is null");
    myMap.put(null,null); //null always be the first element in array, as its hashcode is 0;

    System.out.println(myMap.size());//8 without equal in KeyObject, otherwise is 6
    /**
     *  datastructure.map.MapInfo$KeyObject@5, index 5 has three nodes in the bulket
     */
    System.out.println(myMap); //{null=null, datastructure.map.MapInfo$KeyObject@5=this is 5, datastructure.map.MapInfo$KeyObject@5=this is 8, datastructure.map.MapInfo$KeyObject@5=this is 9, datastructure.map.MapInfo$KeyObject@76ed5528=this is 26, datastructure.map.MapInfo$KeyObject@2c7b84de=this is 35}

    /** ifKeyObject doesn't have equal method, will return null **/
    System.out.println(myMap.get(new KeyObject(8))); //this is 8 .
    System.out.println(myMap.remove(new KeyObject(8))); //this is 8

    /**
     * have 2 nodes in the array (index 5)
     */
    System.out.println(myMap);

    /************************************************************************
     * LinkedHashMap ordering access order vs insert order
     * default is insertion-ordered
     *
     * new LinkedHashMap<Integer,String>(16, .75f, true);
     * With that true you specify that you want an "access-ordered" map, not an "insertion-ordered" map.
     *
     *
     * This means that you will get the values in the order of access (least recently accessed first).
     * (i.e. the most recently accessed entry will be the last entry iterated over).
     *
     * Both your get and put calls constitute an "access".
     */

    /*********************************************************************
     *  Remove eldest Entry : see RemoveEldestEntry
     */


  }

  private static class KeyObject
  {
    private int i ;
    public KeyObject(int i)
    {
    this.i = i;
    }

    @Override public boolean equals(Object o)
    {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      KeyObject keyObject = (KeyObject) o;
      return i == keyObject.i;
    }

    @Override
    public int hashCode()
    {
      if(i < 10)
        return 5;
      else
        return super.hashCode();
    }
  }
}


