package datastructure.string;

/**
 * @author Michael Liu
 */
public class ComputerBinary
{
  public static void main(String[] args)
  {
    System.out.println(computeBinary(5));
  }
  public static String computeBinary(int val) {
    // Base case: value is less than 2
    if (val < 2)
      return Integer.toString(val);
      // Recursive case: binary rep = binary of the header + last digit (odd/even)
    else {
      return computeBinary(val/2)+computeBinary(val%2);
    }
  }

  public static String computeBinary2(int val) {

    StringBuffer sb = new StringBuffer();

    while( val > 1)
    {

      sb.append(val%2);

      val /= 2;

    }

    sb.append(val);

    sb.reverse();

    return sb.toString();


  }
}
