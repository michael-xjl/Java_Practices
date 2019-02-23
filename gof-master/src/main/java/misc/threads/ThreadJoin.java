package misc.threads;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Liu
 */
public class ThreadJoin
{
  private final static Logger LOGGER = Logger.getLogger(ThreadJoin.class.getName());

  class SampleThread extends Thread {
    public int processingCount = 0;

    SampleThread(int processingCount) {
      this.processingCount = processingCount;
      LOGGER.info("Thread Created");
    }

    @Override
    public void run() {
      LOGGER.info("Thread " + this.getName() + " started");
      while (processingCount > 0) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          LOGGER.info("Thread " + this.getName() + " interrupted");
        }
        processingCount--;
      }
      LOGGER.info("Thread " + this.getName() + " exiting");
    }
  }

  @Test
  public void givenStartedThread_whenJoinCalled_waitsTillCompletion()
      throws InterruptedException {
    Thread t2 = new SampleThread(1);
    t2.start();
    LOGGER.info("Invoking join");
    t2.join();
    LOGGER.info("Returned from join");
    assertFalse(t2.isAlive());
  }
  @Test
  public void givenStartedThread_whenJoinCalled_waitsTillCompletion2()
      throws InterruptedException {
    Thread t2 = new SampleThread(1);
    Thread t3 = new SampleThread(2);
    t2.start();
    t3.start();
    LOGGER.info("Invoking join 2");
    t2.join();
    LOGGER.info("Invoking join 3");
//    t3.join();
    LOGGER.info("Returned from join");
    assertFalse(t2.isAlive());
  }
  @Test
  public void givenStartedThread_whenNoJoinCalled_waitsTillCompletion()
      throws InterruptedException {
    Thread t2 = new SampleThread(1);
    t2.start();
    LOGGER.info("Invoking join");
//    t2.join();
    LOGGER.info("Returned from join");
    assertTrue(t2.isAlive());

    //main thread could exit fast than subthread, it means you can't see Thead exiting
  }
}
