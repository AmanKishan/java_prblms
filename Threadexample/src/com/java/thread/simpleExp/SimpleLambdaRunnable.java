package com.java.thread.simpleExp;

public class SimpleLambdaRunnable {

	public static void main(String[] args) {

		Thread t = new Thread(() -> {

			System.out.println("Threading is running t");
			System.out.println("Name of the thread " + Thread.currentThread().getName());
		});


		Thread t1 = new Thread(() -> {

			System.out.println("Threading is running t1");
			System.out.println("Name of the thread " + Thread.currentThread().getName());
		});

		
		

		Thread t2 = new Thread(() -> {

			System.out.println("Threading is running t2");
			System.out.println("Name of the thread " + Thread.currentThread().getName());
		});

		
		t.start();
		
		t1.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		t2.start();
	}
}
