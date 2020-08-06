package com.java.synchronization;

public class SynchRunAnonayms {

	public static void main(String[] args) {
		
		
		ResourceObject r = new ResourceObject();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				//r.test(5);
				//r.testNew(5);
			}
		});

		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				//r.test(10);
				r.testNew(10);
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				//r.test(15);
				//r.testNew(15);
				ResourceObject.testStatic(15);
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

}
