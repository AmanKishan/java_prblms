package com.java.interThreadCommunication.producerConsumer;

public class ProducerComsumerRun {

	public static void main(String[] args) throws InterruptedException {

		final ProducerConsumer pc = new ProducerConsumer();
		
		Thread t1 = new Thread(() -> {
			
			try {
				pc.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});

		Thread t2 = new Thread(() -> {

			try {
				pc.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		t1.start();
		t2.start();
		
		t1.join();
        t2.join();
	}

}
