package misc.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
 *
 * PECS (short for "Producer extends and Consumer super") can be explained by : Get and Put Principle
 *
 * Get And Put Principle (From Java Generics and Collections)
 * It states,
 *
 * use an extends wildcard when you only get values out of a structure
 * use a super wildcard when you only put values into a structure
 * and don’t use a wildcard when you both get and put.
 *
 * @author Michael Liu
 */
public class PECS

{

  public static void main(String[] args)
  {
    producerCall();
    consumerCall();
  }

  /******************************************
   *
   Producer
   /******************************************/

  //For Extends Wildcard(get values i.e Producer extends)
  public static double sum(Collection<? extends Number> nums)
  {
    double s = 0.0;
    for (Number num : nums)
      s += num.doubleValue();
    return s;
  }

  /**
   * Since, sum() method uses extends, all of the following calls are legal. The first two calls would not be legal if extends was not used.
   *
   * EXCEPTION : You cannot put anything into a type declared with an extends wildcard—except for the value null, which belongs to every reference type:
   */
  public static void producerCall()
  {

    //Arrays.asList return a ArrayList  with fixed size underlying array, can't add new element/remove  ( as it didn't implement/overwrite the add method)
    //but can replace existing one.

    List<Integer> ints = Arrays.asList(1, 2, 3);
    assert sum(ints) == 6.0;
    List<Double> doubles = Arrays.asList(2.78, 3.14);
    assert sum(doubles) == 5.92;
    List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
    assert sum(nums) == 8.92;

    //       * EXCEPTION : You cannot put anything into a type declared with an extends wildcard—except for the value null, which belongs to every reference type:

    List<Integer> ints2 = new ArrayList<Integer>();
    ints2.add(1);
    ints2.add(2);
    List<? extends Number> nums2 = ints2;
    nums2.add(null);  // ok
    //nums2.add(2); compile error
    assert nums2.toString().equals("[1, 2, null]");
  }

  /******************************************
   *
          Consumer
   /******************************************/


  //2. For Super Wildcard(put values i.e Consumer super)
  public static void count(Collection<? super Integer> ints, int n)
  {
    for (int i = 0; i < n; i++)
      ints.add(i);
  }

  /**
   Since, count() method uses super, all of the following calls are legal: The last two calls would not be legal if super was not used.

   EXCEPTION : you cannot get anything out from a type declared with a super wildcard—except for a value of type Object, which is a supertype of every reference type:
   */
  public static void consumerCall()
  {
    List<Integer> ints = new ArrayList<Integer>();
    count(ints, 5);
    assert ints.toString().equals("[0, 1, 2, 3, 4]");
    List<Number> nums = new ArrayList<Number>();
    count(nums, 5);
    nums.add(5.0);
    assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");
    List<Object> objs = new ArrayList<Object>();
    count(objs, 5);
    objs.add("five");
    assert objs.toString().equals("[0, 1, 2, 3, 4, five]");


//   EXCEPTION : you cannot get anything out from a type declared with a super wildcard—except for a value of type Object, which is a supertype of every reference type:
    List<Object> objs2 = Arrays.<Object>asList(1,"two");
    List<? super Integer> ints2 = objs2;
    String str = "";
    for (Object obj : ints2) str += obj.toString();

    //for (Integer obj : ints2) str += objs2.toString(); compile error
    System.out.println(str);
    assert str.equals("1two");
  }




  /******************************************
   *
   3. When both Get and Put, don't Use wildcard
   /******************************************/


  //Whenever you both put values into and get values out of the same structure, you should not use a wildcard.

  public static double producerAndConsumer(Collection<Number> nums, int n) {
    count(nums, n);
    return sum(nums);
  }

}
