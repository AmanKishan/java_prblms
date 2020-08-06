package com.java.thread.threadPool;

public class ThreaWokringClass implements Runnable {

	private String msg;
	
	public ThreaWokringClass(String msg) {
	this.msg = msg;
		
	}
	
	@Override
	public void run() {
		
		
		  System.out.println(Thread.currentThread().getName()+" (Start) message = "+msg);  
	        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
	        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  

	}

	private void processmessage() {

		 try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
	}

}
