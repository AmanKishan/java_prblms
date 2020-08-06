package com.java.reentrantMonitor;
/**
 * 
 * @author aman_rastogi
 *
 */

/**The Java runtime system allows a thread to
 *  re-acquire a monitor that it already holds because
 *   Java monitors are reentrant. 
 *   Reentrant monitors are important because they 
 *   eliminate the possibility of a single thread deadlocking itself
 *    on a monitor that it already holds.*/

public class ReentrantMonitor {

	public synchronized void a() {
		b();
		b();
		b();
		System.out.println("here I am, in a()" + Thread.currentThread().getName());
	}

	public synchronized void b() {
		System.out.println("here I am, in b()" + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		
		ReentrantMonitor r = new ReentrantMonitor();
		Thread t = new Thread(()->{
			r.a();
		});
		
		
		Thread t1 = new Thread(()->{
			r.b();
		});
		
		Thread t2 = new Thread(()->{
			r.b();
		});
		t1.start();
		t2.start();
		t.start();
		
	}
}
