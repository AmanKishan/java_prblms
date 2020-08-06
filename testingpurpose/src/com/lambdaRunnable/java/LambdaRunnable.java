package com.lambdaRunnable.java;

import java.util.ArrayList;
import java.util.List;

public class LambdaRunnable {

	public static void main(String[] args) {

		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				System.out.println("Thread 1 is running : " );
			}
		});
		
		Thread th2 = new Thread(()-> System.out.println("Thread 2 is running : " ));
		
		th1.start();
		th2.start();
		
		
		
	}

}
