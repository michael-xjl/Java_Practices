package misc.threads;

/**
 * @author Michael Liu
 */
public class WaitNotify
{
  public static void main(String[] args) throws InterruptedException
  {
    Object monitor = new Object();

    new Thread(new R(monitor,"Wait Thread 1")).start();
    new Thread(new R(monitor,"Wait Thread 2")).start();
//    new Thread(new R(monitor,"Wait Thread 3")).start();
    Thread.sleep(1000);
    synchronized (monitor)
    {
      System.out.println("-------notify() ------");

//      Thread.sleep(19000);
//      monitor.notify();
      System.out.println("-------notify alll------");
//      monitor.notify();
            monitor.notifyAll();
    }
  }



  static class R implements Runnable
  {
    private Object monitor;
    private String name;
    public R(Object monitor, String name)
    {
      this.monitor = monitor;
      this.name = name;
    }

    @Override public void run()
    {

      System.out.println(">>> " + name + " >> " + Thread.currentThread());

      synchronized (monitor)
      {
        try
        {
          //should put wait in while loop
//          System.out.println("name: " + name + " before wait.");
          monitor.wait();
          System.out.println("name: " + name + " after wait.");
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}


