package realinterview;

import org.springframework.util.StringUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author Michael Liu
 */


public class ForkJoinKeyboard extends RecursiveTask<StringBuffer>
{
  private  static String ar;
  private  static String transformCommand = "H,V,5,V";

  private  int from;
  private  int to;

  public static void main(String[] args) {

//    String inputStr = "abcdefghijklmnopqrstovyxyz1234567890_+";
    String inputStr = "hello world hello world hello world hello world hello world hello world";

    ForkJoinKeyboard fj = new ForkJoinKeyboard(inputStr, 0, inputStr.length());
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    final StringBuffer invoke = forkJoinPool.invoke(fj);

    System.out.println(invoke);


  }

  public ForkJoinKeyboard(String str, int from, int to)
  {
    this.ar = str;
    this.from = from;
    this.to = to;
  }

  @Override
  public StringBuffer compute()
  {
    if(to - from <= 5) {

//        return Utility.transfer(ar.substring(from,to));
      return Keyboard.transform(transformCommand, ar.substring(from,to));
    }
    else {
      int m = (from + to) / 2;
      ForkJoinKeyboard forkJoin1 = new ForkJoinKeyboard(ar, from, m);
      ForkJoinKeyboard forkJoin2 = new ForkJoinKeyboard(ar, m , to);
//      forkJoin1.compute();
      forkJoin2.fork();
       return forkJoin1.compute().append(forkJoin2.join());
//       return forkJoin2.join().append(forkJoin1.compute());
    }

  }
}

 class Utility
{
  public static StringBuffer transfer(String str)
  {
    return new StringBuffer(str).append("|");
  }
}

