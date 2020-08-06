package com.java.synchronization;

public class ResourceObject {

	final Integer objInt = new Integer(10);

	public synchronized void test(int n) {

		for (int i = 1; i < 11; i++) {

			System.out.println("Test  is runing " + Thread.currentThread().getName() + " - " + i * n);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void testNew(int n) {

		//System.out.println(Thread.currentThread().getName() + " #### " + n);// this is asynchronous
		 
		//in this case lock is on other object thus : testNew and Test both method run in non synchronized way
		//in this case lock is on other object thus : testNew and Test and Test static all method run in non synchronized way
		//synchronized (objInt) {

		// In this case lock is on object so : testNew and Test both method run in  synchronized way
		//In this case lock is on object so : testNew and Test static method run in non synchronized way
			 //synchronized (this) {
		
		//this case is class level lock thus testNew and test Static is synchronized
		//this case is class level lock thus testNew and test is non synchronized
				  synchronized (ResourceObject.class) {	 
		

			for (int i = 1; i < 10; i++) {

				System.out.println("Test New is runing " + Thread.currentThread().getName() + " %%%% " + i * n);

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}
	
	
	public static synchronized void testStatic(int n) {
		
		for (int i = 1; i < 10; i++) {

			System.out.println("Test static  is runing " + Thread.currentThread().getName() + "  ***** " + i * n);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
