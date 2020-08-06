package com.java.synchronization;

public class ThreadThree extends Thread {

	ResourceObject r;
	
	public ThreadThree(ResourceObject r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		
		r.test(5);
	}
	
}
