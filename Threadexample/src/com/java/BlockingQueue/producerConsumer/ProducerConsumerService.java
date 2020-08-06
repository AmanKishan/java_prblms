package com.java.BlockingQueue.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

	public static void main(String[] args) {

		
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		
		new Thread(p).start();
		new Thread(c).start();
	}

}
