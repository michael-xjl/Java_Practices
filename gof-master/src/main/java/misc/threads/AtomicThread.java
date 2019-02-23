package misc.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Michael Liu
 */
public class AtomicThread
{
  public static void main(String[] args)
  {
    byte a = -5;
    byte b = (byte)(a+Byte.MIN_VALUE);
    System.out.println(b);//123 = -5 - 128 + 256

    a = 5;
    //b = (a+Byte.MAX_VALUE); compile error
    b = (byte)(a+Byte.MAX_VALUE);
    System.out.println(b); //5 + 127 - 256 = 124

    AtomicBoolean at = new AtomicBoolean(false);
    ExecutorService es = Executors.newFixedThreadPool(2);

    es.submit( () -> {while(true){
      Thread.sleep(1000);
      System.out.println("t1: " + at.get());}});

    es.submit( () -> {while(true){
      Thread.sleep(2000);
      System.out.println("t2: " + at.getAndSet(true));}});

    es.shutdown();
  }
}
