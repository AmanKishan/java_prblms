package com.java.thread.simpleExp;

public class SimpleThreadRunnanleAnonymous {

	public static void main(String[] args) {

		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Threading is running ");
				System.out.println("Name of the thread " + Thread.currentThread().getName());
				
			}
		});
		
		t.start();

	}

}
