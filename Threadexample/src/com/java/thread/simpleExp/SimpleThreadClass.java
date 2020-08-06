package com.java.thread.simpleExp;

public class SimpleThreadClass  extends Thread{

	@Override
	public void run() {
	
	System.out.println("Threading is running ");
	System.out.println("Name of the thread " + Thread.currentThread().getName());
	
	}
	
	
	
	public static void main(String[] args) {
		SimpleThreadClass
		 s = new SimpleThreadClass();
		s.start();
		

	}

}
