package com.java.interThreadCommunication.producerConsumer;

import java.util.LinkedList;

public class ProducerConsumer {

	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 4;

	public void producer() throws InterruptedException {

		int value = 0;
		while(true) { 
		
			synchronized (this) {
			
				if(list.size() == capacity)
					wait();
				
				  System.out.println("Producer produced-"
                          + value);
				list.add(value);
				
				value++;
				
				
				notify();
				
				Thread.sleep(100);//easy to understand the data flow
			}
			
			
		}
		
		
	}

	public void consumer() throws InterruptedException {

		while(true) {
			synchronized (this) {
				
				if(list.size() == 0)
					wait();
				int val = list.removeFirst();
				System.out.println("Consumer vaue is " + val);
				
				notify();
				
				Thread.sleep(100);
			}
		}
	}
}
