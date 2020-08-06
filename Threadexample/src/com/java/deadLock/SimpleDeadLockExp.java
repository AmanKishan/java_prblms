package com.java.deadLock;

public class SimpleDeadLockExp {

	public static void main(String[] args) {

		final String resource1 = "Resource one";
		final String resource2 = "Resource two";

		Thread t1 = new Thread(() -> {

			synchronized (resource1) {

				System.out.println("Thread 1 has resource 1");
				try { Thread.sleep(100);} catch (Exception e) {}  
				synchronized(resource2) {
				
					System.out.println("Thread 1 try to acquire lock on resource 2");
				}
			}
		});

		Thread t2 = new Thread(() -> {

			synchronized (resource2) {

				System.out.println("Thread 2 has resource 2");
				try { Thread.sleep(100);} catch (Exception e) {}  
				synchronized(resource1) {
				
					System.out.println("Thread 2 try to acquire lock on resource 1");
				}
			}

		});

		t1.start();
		t2.start();

	}

}
