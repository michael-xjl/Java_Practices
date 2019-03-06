package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael Liu
 */
public class ArraysClass
{
  public static void main(String[] args)
  {
    double[] da = new double[50];
    Arrays.setAll(da, i -> i*1.5);
    System.out.println(Arrays.toString(da));

    double[] da2 = new double[]{0.1,0.2,0.3,0.4,0.5};

    double[] da3 = Arrays.copyOf(da2, 10);
    System.out.println(Arrays.toString(da2));
    System.out.println(Arrays.toString(da3));

    double[] da4 = Arrays.copyOf(da2, 3);
    System.out.println(Arrays.toString(da2));
    System.out.println(Arrays.toString(da4));
    
    
    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    
    Integer[] ia = new Integer[]{11,21,31,41,51};
    Integer[] ia2 = new Integer[]{11,21};

    final Integer[] toia = list.toArray(ia);
    final Integer[] toia2 = list.toArray(ia2);

    System.out.println(Arrays.toString(ia));
    System.out.println(Arrays.toString(toia));

    System.out.println(Arrays.toString(ia2));
    System.out.println(Arrays.toString(toia2));

  }
}
