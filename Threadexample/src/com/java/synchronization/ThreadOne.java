package com.java.synchronization;

public class ThreadOne extends Thread {

	ResourceObject r;
	
	public ThreadOne(ResourceObject r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		
		r.test(5);
	}
	
}
