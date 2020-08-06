package com.creational.deisgn.pattern.singalton;

/**
 * The above implementation works fine in case of single threaded
 * environment but when it comes to multithreaded systems,
 * it can cause issues if multiple threads are inside the if loop at the same time.
 * 
 * Thus, we need to create a thread-safe singleton class.
 * 
 * 
 * @author Aman Rastogi
 *
 */
public class LazySingelton implements Cloneable{

	private static LazySingelton lazySingeltonObj ;

	private LazySingelton() {
	}

	public static LazySingelton getSingelton() {
		if (lazySingeltonObj == null) {
			lazySingeltonObj = new LazySingelton();
		}
		return lazySingeltonObj;

	}
	
	 @Override
	  protected Object clone() throws CloneNotSupportedException 
	  {
	    throw new CloneNotSupportedException();
	  }
}
