package misc.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Michael Liu
 */
public class ExecutorWithThreadLocal
{
  public static void main(String[] args)
  {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    RunnalbeExecutor tr =  new RunnalbeExecutor("u1");
    executor.submit(tr);
    executor.submit(tr);
  }
}

class RunnalbeExecutor implements Runnable
{

  private  String userName;
  private static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
//  private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

  @Override public void run()
  {
    THREAD_LOCAL.set("Thread Local val: [" + userName + "] in Thread: " + Thread.currentThread());
    System.out.println(THREAD_LOCAL.get());
    while(true)
    {
      try
      {
        System.out.println(THREAD_LOCAL.get());
        System.out.println(System.identityHashCode(THREAD_LOCAL));

        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      if(Thread.currentThread().getName().equalsIgnoreCase("pool-1-thread-1"))
      {
        userName = "new u1";
        THREAD_LOCAL.set("Thread Local val: [" + userName + "] in Thread: " + Thread.currentThread());

        //        THREAD_LOCAL.set("new value");
      }
    }
  }

  public RunnalbeExecutor(String userName)
  {
    this.userName = userName;
  }
}
