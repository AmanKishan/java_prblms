package com.java.thread.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleThreadPool {

	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
		
		//ExecutorService executor = Executors.newCachedThreadPool();//create on demand
		for(int i=0 ;i < 10;i++) {
			
			Runnable worker = new  ThreaWokringClass("Hello"+i);
			executor.execute(worker);
			Future<String>  f = executor.submit(worker,"Hello"+i);//return any passed object 
			//Future<?>  f = executor.submit(worker); // return null
			System.out.println(f.get());//
		}
		
		executor.shutdown();  
        while (!executor.isTerminated()) {   }
        
        System.out.println("Finished all threads");  
	}
}
