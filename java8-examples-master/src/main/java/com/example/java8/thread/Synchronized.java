package com.example.java8.thread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}

class VolatileCounter {
    private  AtomicInteger c = new AtomicInteger(0);

    public  void increment() {
//        c++;
    	c.getAndIncrement();
    }

    public  void decrement() {
//        c--;
    	c.getAndDecrement();
    }

    public  int value() {
//        return c;
    	return c.get();
    }
}

public class Synchronized {
	
	

	public static void main(String[] args)
	{
		SynchronizedCounter sc = new SynchronizedCounter();
		
		VolatileCounter vc = new VolatileCounter();
//		multiThreadIncrease(sc);
		multiThreadIncrease(vc);

	}
	
	public static void multiThreadIncrease(SynchronizedCounter sc)
	{
		for(int i = 0 ; i < 100 ; i++)
		{
			Thread t = new Thread(()->{
				
				try {
					
					Thread.sleep(new Random().nextInt(10) * 1000);
					sc.increment();
				} catch (Exception e) {

					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  : " + sc.value());
				
			}, "thread - " + i);
			t.start();
		}
		
		System.out.println(Thread.currentThread().getName() + "  : " + sc.value());
	}
	
	
	public static void multiThreadIncrease(VolatileCounter sc)
	{
		for(int i = 0 ; i < 100 ; i++)
		{
			Thread t = new Thread(()->{
				
				try {
					
					Thread.sleep(new Random().nextInt(10) * 1000);
					sc.increment();
				} catch (Exception e) {

					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  : " + sc.value());
				
			}, "thread - " + i);
			t.start();
		}
		
		System.out.println(Thread.currentThread().getName() + "  : " + sc.value());
	}
	
}
