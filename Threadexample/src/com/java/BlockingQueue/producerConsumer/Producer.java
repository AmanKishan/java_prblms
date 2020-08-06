package com.java.BlockingQueue.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {

			Message msg = new Message();
			msg.setMsg("Msg" + i);
			System.out.println("Producer produced messages " + msg );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				queue.put(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// add exit message
		Message msg = new Message();
		msg.setMsg("Exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
