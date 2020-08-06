package com.creational.deisgn.pattern.singalton;

public class ThreadSafeDoubleCheck {

	
	private static ThreadSafeDoubleCheck threadSafeDoubleCheckObj;
	private ThreadSafeDoubleCheck() {
	}
	
	public static ThreadSafeDoubleCheck getSingelton() {
		if(threadSafeDoubleCheckObj == null) {
			
			synchronized (ThreadSafeDoubleCheck.class) {
				
				if(threadSafeDoubleCheckObj == null) {
					threadSafeDoubleCheckObj = new ThreadSafeDoubleCheck();
				}
			}
		}
		
		return threadSafeDoubleCheckObj;
	}
}
