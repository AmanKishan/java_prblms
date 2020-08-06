package com.java.synchronization;

public class ThreadTwo extends Thread {

	ResourceObject r;
	
	public ThreadTwo(ResourceObject r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		
		r.test(5);
	}
	
}
