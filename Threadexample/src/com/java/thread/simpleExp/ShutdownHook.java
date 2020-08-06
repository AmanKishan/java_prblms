package com.java.thread.simpleExp;

 /**
 *Shutdown Hooks are a special construct that allow developers to plug in a
 * piece of code to be executed when the JVM is shutting down. 
 * This comes in handy in cases where we need to do special clean up 
 * operations in case the VM is shutting down
 */
public class ShutdownHook {
	
	
	
	public static void main(String[] args) throws Throwable {

		Thread t = new Thread(()-> {
			
			System.out.println("Shutdown hook task completed!!");
			
			  
			
		});
	
		
	
		Runtime r=Runtime.getRuntime();
	r.addShutdownHook(t);
	System.exit(0);
	try{Thread.sleep(3000);}catch (Exception e) {}  
	
	}

}
