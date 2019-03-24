package misc.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * Generic is  invariant, but array is covariant
 *
 * Double[] is a subtype of Number[], but a List<Double> is NOT a subtype of List<Number>. A List<Double>, however, is a List<? extends Number>.
 *
 * @author Michael Liu
 */
public class InvariantCovariant
{
  public static void main(String[] args)
  {

    //array
    Number[] numbers = new Number[1];
    numbers[0] = new Double(0.1); //fine
    numbers = new Double[2]; //fine

    //generic
    List<Number> numberList = new ArrayList<>();
    numberList.add(new Double(2.0)); //fine
    //numberList = new ArrayList<Double>(); compilation error. can use extend wildcard <? extend Number> . {@code PECS}

    //wild generic ? extend
    List<? extends Number> wildNumberList = new ArrayList<>();
    //wildNumberList.add(new Double(2.0)); //compilation error
    wildNumberList = new ArrayList<Double>(); //compilation fine.



    List<Integer> intList = new ArrayList<>();
    add(intList);
    add(numberList);
    add(wildNumberList);

    //add2(intList); //compile error
    add2(numberList);
    //add2(wildNumberList); //compile error

    add3(intList);
    add3(numberList);
    add3(wildNumberList);

  }

  /**
   * add == add3
   * @param eList
   * @param <E>
   */
  public  static <E extends Number> void add(List<E> eList)
  {

  }

  public  static  void add2(List<Number> eList)
  {

  }

  public  static  void add3(List<? extends Number> eList)
  {

  }
}
