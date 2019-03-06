package misc.threads;

/**
 *
 * Thread enum State:
 * NEW,RUNNABLE,TERMINATED
 *
 * BLOCKED, WAITING, and TIMED_WAITING are important thread states
 *
 * ----- BLOCKED state
 * A thread that is blocked waiting for a monitor lock is in this state.”
 * BLOCKED state when it’s waiting for a monitor lock to enter a synchronized block/method
 *
 * -- Waiting **** A thread goes to WAITING status will release the lock , then make itself into Waiting status
 * Object#wait() with no timeout
 * Thread#join() with no timeout
 *
 *
 * Object.wait() on an object is in WAITING state until another thread to call Object.notify() or Object.notifyAll() on that object
 * Thread.join() is in WAITING state for a specified thread to terminate
 *
 * Explaining it in technical terms, you are thread T1 and the cop is thread T2. You released your lock (i.e. you stopped driving the car), and went into the WAITING state. Until the cop (i.e. T2) lets you go, you will be stuck in this WAITING state.
 *
 *
 * -----TIMED_WAITING
 * Thread#sleep(t) --not release lock
 * Object#wait(t) with timeout -- release lock
 * Thread#join() with timeout
 *
 * A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
 *
 * Explaining it in technical terms, you are thread T1 and your neighbor is thread T2. You release lock (i.e. stop driving the car) and wait up to 10 minutes. If your neighbor, T2, doesn’t come out in 10 minutes, you start driving the car again.
 *
 *
 *
 *
 *
 *https://stackoverflow.com/questions/28378592/java-thread-state-transition-waiting-to-blocked-or-runnable
 *
 * NEW ---start() -->|+++++ RUNNABLE ++++++++| -----> TERMINATED
 *                      |                 |
 *                      |                 |
 *                      sleep(t)|--TIMED WAITING--|(time elapsed)
 *
 *
 *
 *
 *
 *
 *
 *
 * @author Michael Liu
 */
public class ThreadStatus
{
  public static void main(String[] args) throws InterruptedException
  {
    Object lock = new Object();
    final WaitCondition waitCondition = new WaitCondition();
    waitCondition.isWait = true;

    Thread t1 = new Thread(()->
    {
        synchronized (lock)
        {
          while(waitCondition.isWait)
          {
            try
            {
              System.out.println("t1 : " + Thread.currentThread().getState());
              System.out.println("t1 start going to waiting");
              lock.wait();
              System.out.println("t1 is woke up.");
            }
            catch (InterruptedException e)
            {
              System.out.println("t1 is interuppted");
              //e.printStackTrace();
            }
          }
          System.out.println("t1 end going to waiting");
        }
    });


    Thread t2 = new Thread(()->
    {
      synchronized (lock)
      {
        try
        {
          Thread.currentThread().sleep(20000000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        //          Thread.dumpStack();
//          Thread.holdsLock(lock);
      }
    });



    t1.start();
//    t2.start();
//    Thread.dumpStack();
    System.out.println("main " + Thread.holdsLock(lock));

    System.out.println("t1 : " + t1.getState());
    Thread.sleep(2000);
    System.out.println("t1 : " + t1.getState());
    Thread.sleep(2000);

    waitCondition.isWait = false;
    t1.interrupt();


    System.out.println("main " + Thread.currentThread().getState());

    t1.join();
    System.out.println("main " + Thread.currentThread().getState());


  }

  private static class WaitCondition
  {
    public boolean isWait = false;

  }
}
