package misc.classloader.example1;

import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class Counter implements ICounter {
  private int counter;

  public Counter()
  {
    Exception e = new Exception();
    StackTraceElement[] stackTrace = e.getStackTrace();
    System.out.println(Arrays.toString(stackTrace));
  }

  public String message() {
    return "Version 1";
  }
  public int plusPlus() {
    return counter++;
  }
  public int counter() {
    return counter;
  }
}