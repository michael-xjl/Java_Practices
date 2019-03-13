package datastructure.map;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * usually loadfactor will determe when to resize hashtable, it means the count of eleements reach  16*0.75 = 12, it will resize table.
 * but even one bucket of initial capacity 16 is occupied, but if the bucket could have more than 8 collision elements, it will also resize when reache such THRESHOLD
 *
 * @author Michael Liu
 */
public class CollisionTest
{
  public static void main(String[] args) throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {

    testExpandSize();
  }

  private static void testExpandSize() throws NoSuchFieldException, IllegalAccessException
  {
    HashMap<Person, String> hm = new HashMap<Person, String>();
    for (int i = 1; i <= 8; i++) {
      // 7 Entry in same bucket(linkedlist)
      hm.put(new Person(), String.valueOf(i));
    }
    System.out.println("Number of Buckets in HashMap : "+bucketCount(hm));
    System.out.println("Number of Entry in HashMap :  " + hm.size());
    System.out.println("**********************************");
    /**
     * no resize, as the elements in collision is nto great than 8, and the total size is 7 < 16
     */
    hm.put(new Person(16), "16"); //mode 16 == index 0;
    System.out.println("Number of Buckets in HashMap : "+bucketCount(hm));
    System.out.println("Number of Entry in HashMap :  " + hm.size());
    System.out.println("**********************************");
    // 13th element in different bucket
    //will resize, as the 32 mode 16 == 0, but after risizing, will put new Person(16) to new index
    hm.put(new Person(32), "32");
    System.out.println("Number of Buckets in HashMap : "+bucketCount(hm));
    System.out.println("Number of Entry in HashMap :  " + hm.size());

    hm.put(new Person(64), "64");
    System.out.println("Number of Buckets in HashMap : "+bucketCount(hm));
    System.out.println("Number of Entry in HashMap :  " + hm.size());
  }

  public static int bucketCount(HashMap<Person, String> h)
      throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field tableField = HashMap.class.getDeclaredField("table");
    tableField.setAccessible(true);
    Object[] table = (Object[]) tableField.get(h);
    System.out.println(Arrays.toString(table));
    return table == null ? 0 : table.length;
  }
}

class Person {
  int age = 0;
  Person() {
  }
  Person(int a) {
    age = a;
  }
  @Override
  public boolean equals(Object obj) {
    return false;
  }
  @Override
  public int hashCode() {
    if (age != 0 && age < 10) {
      return 1;
    } else {
      return age;
    }
  }

  @Override
  public String toString()
  {
    return String.valueOf(age);
  }
}
