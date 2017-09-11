package com.example.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SeqThreads {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		
		runSeqThreads2();
		

	}
	
	public static void runSeqInMainThread()
	{
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread ta = new Thread(r, "Thread A");
		Thread tb = new Thread(r, "Thread B");
		Thread tc = new Thread(r, "Thread C");
		
		try
		{
		ta.start();
		ta.join();
		tb.start();
		tb.join();
		tc.start();
		}catch(Exception ex)
		{
			
		}
		
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
	
	public static void runSeqThreads()
	{
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};	
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};	
		
		Runnable r3 = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(3000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};		
		
		Thread ta = new Thread(r1, "Thread A");
		Thread tb = new Thread(r2, "Thread B");
		Thread tc = new Thread(r3, "Thread C");	
		
		ta.start();
		tb.start();
		tc.start();		
	}

	
	public static void runSeqThreads2()
	{
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(() -> System.out.println("Message 1"));
		es.submit(() -> System.out.println("Message 2"));
		es.submit(() -> System.out.println("Message 3"));
		es.shutdown();
	}
}
