package com.java.thread.simpleExp;

public class SimpleRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Threading is running ");
		System.out.println("Name of the thread " + Thread.currentThread().getName());

	}

	public static void main(String[] args) {

		SimpleRunnable s = new SimpleRunnable();
		Thread t = new Thread(s);
		t.start();
		
	}

}
