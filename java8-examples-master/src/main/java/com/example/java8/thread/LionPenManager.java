package com.example.java8.thread;

import java.util.Random;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class LionPenManager {

	   public static void main(String[] args) throws Exception {
//		   cyclicBarrierRun();
		   cyclicBarrierRunPeriodly();
//		   testSchedulerExecutor();
	   }
	   
	
	
	   private void removeAnimals() { System.out.println("Removing animals"); }
	   private void cleanPen() { System.out.println("Cleaning the pen"); }
	   private void addAnimals() { System.out.println("Adding animals"); }

	   public synchronized void performTask() {
	      removeAnimals();
	      cleanPen();
	      addAnimals();
	   }
	   
	   
	   
	   
	   public static void synchronizedRun()
	   {
		      final ExecutorService service = Executors.newFixedThreadPool(6);
		      try {

		         LionPenManager manager = new LionPenManager();
//		         for(int i=0; i<4; i++)
//		            service.submit(() -> manager.performTask());
		         
		         IntStream.range(1, 7).forEach(i->service.submit(() -> manager.performTask()));
		      } finally {
		         if(service != null) service.shutdown();
		      }
	   }	   


	   
	   public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		      try {
		         removeAnimals();
		         c1.await();		         
		         cleanPen();
		         c2.await();
		         addAnimals();
		      } catch (InterruptedException | BrokenBarrierException e) {
		         // Handle checked exceptions here
		      }
		   }
	   
	   public static void cyclicBarrierRun()
	   {
		      ExecutorService service = null;
		      try {
		         service = Executors.newFixedThreadPool(8);

		         LionPenManager manager = new LionPenManager();
		         CyclicBarrier c1 = new CyclicBarrier(4,() -> System.out.println("*** Animal Cleaned!"));
		         CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
		         for(int i=0; i<8; i++)
		            service.submit(() -> manager.performTask(c1,c2));
		      } finally {
		         if(service != null) service.shutdown();
		      }
	   }
	   
	   public void performTask2(CyclicBarrier c1, CyclicBarrier c2 , CyclicBarrier c3) {
		      try {
		         removeAnimals();
		         c1.await();		         
		         cleanPen();
		         c2.await();
		         addAnimals();
		         //c3.await();
		      } catch (InterruptedException | BrokenBarrierException e) {
		         // Handle checked exceptions here
		      }
		   }
	   
	   public void performTask2Shift(CyclicBarrier c1, CyclicBarrier c2 , CyclicBarrier c3, CyclicBarrier c4)
	   {
		   performTask2(c1,c2,c3);
	   }
	   
	   public static void cyclicBarrierRunPeriodly()
	   {
		   ScheduledExecutorService service = null;
		      try {

		    	  service =
						     Executors.newScheduledThreadPool(8);
		         LionPenManager manager = new LionPenManager();
		         CyclicBarrier c4 = new CyclicBarrier(4, () -> System.out.println("*** Shift Finished"));
		         CyclicBarrier c1 = new CyclicBarrier(4,() -> System.out.println("*** Animal Cleaned!"));
		         CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
		         CyclicBarrier c3 = new CyclicBarrier(4, () -> {System.out.println("*** Animal Added!");});

//		         for(int i=0; i<4; i++)
//		            service.scheduleWithFixedDelay(() -> manager.performTask2(c1,c2,c3), 0, 1, TimeUnit.SECONDS);
		         System.out.println("YYYY");
		         service.schedule(()->System.out.println("yes yes"),0,TimeUnit.SECONDS);
		         ScheduledFuture<String> schedule = service.schedule(()->{System.out.println("yes yes , I have return"); return "this is return";},0,TimeUnit.SECONDS);
		         System.out.println(schedule.get(3,TimeUnit.SECONDS));
		         
		         service.scheduleWithFixedDelay(() -> System.out.println("--->"), 1, 1, TimeUnit.SECONDS);

		      } catch (InterruptedException | ExecutionException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		    	  System.out.println("NNNNN");
		         if(service != null) service.shutdown();
		      }
	   }	   
	   
	   public static void testSchedulerExecutor() throws Exception {
			final ScheduledExecutorService executor = Executors.newScheduledThreadPool(8);
			final CyclicBarrier c1 = new CyclicBarrier(4, () -> {System.out.println("Task Done Increase!");});
			final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {System.out.println("done!"); executor.shutdown();});
			
			for(int i = 0 ; i < 4; i++)
			{
				 ScheduledFuture<?> scheduledFuture = 
			executor.scheduleWithFixedDelay(new Runnable() {
				int count = 0;


				@Override
				public void run() {
					// TODO Auto-generated method stub
					++count;
					System.out.printf("Execution count %d\n", count);
					Random r = new Random();
					try {
						Thread.sleep(1000 * r.nextInt(5));
						c1.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(count>8) {
//						executor.shutdown();
						try {
							cyclicBarrier.await();
						} catch (InterruptedException | BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
					}

				}
				
			}, 0, 1000, TimeUnit.MILLISECONDS);
			}
//			executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
			System.out.println("Completed");
		}
		 

	}