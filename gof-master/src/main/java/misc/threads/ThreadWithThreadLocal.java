package misc.threads;

/**
 * Thread Local val: [u1] in Thread: Thread[update_thread,5,main]
 * Thread Local val: [u1] in Thread: Thread[update_thread,5,main]
 * Thread Local val: [u1] in Thread: Thread[read_thread,5,main]
 * Thread Local val: [u1] in Thread: Thread[read_thread,5,main]
 * 703410799
 * 703410799
 * Thread Local val: [u1] in Thread: Thread[read_thread,5,main]
 * Thread Local val: [new u1] in Thread: Thread[update_thread,5,main]
 * 703410799
 * 703410799
 * Thread Local val: [u1] in Thread: Thread[read_thread,5,main]
 * 703410799
 * Thread Local val: [new u1] in Thread: Thread[update_thread,5,main]
 * 703410799
 * Thread Local val: [u1] in Thread: Thread[read_thread,5,main]
 *
 * @author Michael Liu
 */
public class ThreadWithThreadLocal
{
  public static void main(String[] args)
  {
    RunnalbeThreadLocal tr =  new RunnalbeThreadLocal("u1");
    new Thread(tr, "read_thread").start();
    new Thread(tr,"update_thread").start();
  }
}

class RunnalbeThreadLocal implements Runnable
{

  private  String userName;
  private ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
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
      if(Thread.currentThread().getName().equalsIgnoreCase("update_thread"))
      {
        userName = "new u1";
        THREAD_LOCAL.set("Thread Local val: [" + userName + "] in Thread: " + Thread.currentThread());

        //        THREAD_LOCAL.set("new value");
      }
    }
  }

  public RunnalbeThreadLocal(String userName)
  {
    this.userName = userName;
  }
}
