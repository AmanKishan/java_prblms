package com.java.BlockingQueue.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
		Message msg;
		
		try {
			while((msg = queue.take()).getMsg()!= "Exit") {
				Thread.sleep(500);
		System.out.println("Messag`e consumed " + msg);		
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
