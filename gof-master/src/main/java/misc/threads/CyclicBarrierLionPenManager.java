package misc.threads;

/**
 * @author Michael Liu
 */
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CyclicBarrierLionPenManager {

  private String removeAnimals()
  {
    final String removing_animals = "Removing animals";
    System.out.println(removing_animals);
    return removing_animals;
  }

  private String cleanPen()
  {
    final String cleaning_the_pen = "Cleaning the pen";
    System.out.println(cleaning_the_pen);
    return cleaning_the_pen;
  }

  private String addAnimals()
  {
    final String adding_animals = "Adding animals";
    System.out.println(adding_animals);
    return adding_animals;
  }

  public  void  performTask(CyclicBarrier cb)  {
    try {
      removeAnimals();
      cb.await();
      cleanPen();
      cb.await();
      addAnimals();
      cb.await();

    }catch (Exception ex)
    {
      System.out.println(ex);
    }
  }


  public  void  performTask(CyclicBarrier cb, Map map)  {
    try {
      removeAnimals();
      cb.await();
      cleanPen();
      cb.await();
      addAnimals();
    }catch (Exception ex)
    {
      System.out.println(ex);
    }
  }

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      CyclicBarrier cb = new CyclicBarrier(4, () -> {
        System.out.println("CyclicBarrier Reached.");
      });
      service = Executors.newFixedThreadPool(4);
      CyclicBarrierLionPenManager manager = new CyclicBarrierLionPenManager();
      for(int i=0; i<9; i++)
        service.submit(() -> manager.performTask(cb));

    } catch(Exception ex)
    {
      System.out.println(ex);
    }
    finally {
      if(service != null) service.shutdown();
    }
  }

  @Test
  public void testCyclicBarrierOrder()
  {
    Map executionOrderMap = Collections.synchronizedMap(new HashMap<>());

    ExecutorService service = null;
    try {
      CyclicBarrier cb = new CyclicBarrier(4);
      service = Executors.newFixedThreadPool(4);
      CyclicBarrierLionPenManager manager = new CyclicBarrierLionPenManager();
      for(int i=0; i<8; i++)
        service.submit(() -> manager.performTask(cb));

    } catch(Exception ex)
    {
      System.out.println(ex);
    }
    finally {
      if(service != null) service.shutdown();
    }
  }
}