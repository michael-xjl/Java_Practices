package misc.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Michael Liu
 */
public class ProducerConsumer
{

 static  BlockingQueue<String> bq = new LinkedBlockingDeque<>(10);


  public static void main(String[] args)
  {
    new Thread(new Producer(bq)).start();
    new Thread(new Consumer(bq)).start();
  }




  static class Producer implements Runnable
  {
    BlockingQueue<String> bq;
    public Producer(BlockingQueue bq)
    {
      this.bq = bq;
    }

    @Override public void run()
    {
      for(int i = 0 ;;i++)
      {
        if(bq.offer(" added : "  + i))
          System.out.println(" added " + i);
      }
    }
  }
  static class Consumer implements Runnable
  {
    BlockingQueue<String> bq;
    public Consumer(BlockingQueue bq)
    {
      this.bq = bq;
    }

    @Override public void run()
    {
        try
        {

          while(true)
          {
          String take = bq.take();
          System.out.println(" get " + take);
          Thread.sleep(1000);
          }
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
    }
  }
}
