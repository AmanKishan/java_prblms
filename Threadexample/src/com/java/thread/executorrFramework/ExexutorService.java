package com.java.thread.executorrFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExexutorService {

	
	 
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(10000000);
		// annonymous class
		/*
		 * Runnable r = new Runnable() {
		 * 
		 * @Override public void run() {
		 * 
		 * } };
		 */

		Runnable runnableTask = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task's execution";
		};

		Callable<String> callableTask1 = () -> {
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task's execution 1";
		};

		Callable<String> callableTask2 = () -> {
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task's execution 2";
		};

		// annonymous class
		/*
		 * Callable<String> callAbleTaskOld = new Callable<String>() {
		 * 
		 * @Override public String call() throws Exception { 
		 * method stub return null; } };
		 */

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask1);
		callableTasks.add(callableTask2);
		
		executor.execute(runnableTask);//execute runnable 
		
		Future<?> runnableFuture = executor.submit(runnableTask);//execute runnable
		System.out.println("Runnable future " + runnableFuture.get());//return null
		
		Future<String> callableTaskFuture = executor.submit(callableTask);//one callable at a time
		
		try {
			//here timout is used , if we want the result to be executed with 200milisecond 
			System.out.println("callableTasksFuture " + callableTaskFuture.get(200,TimeUnit.MILLISECONDS));
		} catch (TimeoutException e1) {
			// TODO Auto-generated catch block
			System.out.println("Timeout Exeception occur " + e1);
		}
		

		//invoke any
		
		String result = executor.invokeAny(callableTasks);
		System.out.println("Any task from callableTasks " + result);
		
		
		//invokeAll
		
		
		 List<Future<String>> futureList = executor.invokeAll(callableTasks);
		 
		 futureList.forEach(future->{
			try {
				System.out.println(" " + future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		 
		
		 //now we need to shutdown the executor
		 executor.shutdown();//stop tasking new task for executor 
		 try {
		
			 if(!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				 List<Runnable> stillWaitingtask = executor.shutdownNow();
				 //return the still waiting task
			 }
		 }catch(InterruptedException e) {
			 executor.shutdownNow();
		 }
		 
		 
		 //SchedulerExecutor service - it schedule the rask to be run for specific time in pecific delay
		 //TODO
		 
		 
	}
}
