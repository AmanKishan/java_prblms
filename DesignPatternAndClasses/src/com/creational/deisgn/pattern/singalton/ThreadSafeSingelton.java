package com.creational.deisgn.pattern.singalton;
/***
 * This implementation works fine and provides thread-safety 
 * but it reduces the performance because of cost associated with the synchronized method,
 * although we need it only for the first few threads who might create the separate instances 
 * .To avoid this extra overhead every time, double checked locking principle is used. 
 * In this approach, the synchronized block is used inside the 
 * if condition with an additional check to ensure that only 
 * one instance of singleton class is created.
 * 
 * 
 * @author aman_rastogi
 *
 */
public class ThreadSafeSingelton {

	private static ThreadSafeSingelton threadSageSingeltonObj ;

	private ThreadSafeSingelton() {

	}

	public static synchronized ThreadSafeSingelton getSingelton() {
		if (threadSageSingeltonObj == null) {
			threadSageSingeltonObj = new ThreadSafeSingelton();
		}

		return threadSageSingeltonObj;
	}
}
