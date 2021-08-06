package com.helpingduck.loadbalance.strategy.impl;

import com.helpingduck.loadbalance.model.ServerDetails;
import com.helpingduck.loadbalance.strategy.LoadBalance;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLB extends LoadBalance {

	//Maintain a counter to get server ip, if counter is greater than all servers length then make is zero
	// since we are increasing the counter to get next ip in sequence  , thus we need to write thread safe code here
	private static int counter = 0;
	private static final ReentrantLock lock = new ReentrantLock();

	public RoundRobinLB(List<String> serversList){
		super(serversList);
	}
	@Override
	public ServerDetails getServerDetails() {
		lock.lock();
		System.out.println("Thread Name : " + Thread.currentThread().getName());
		try{
			if(counter == super.serversList.size()){
				counter = 0;
			}
			String serverIp = super.serversList.get(counter);
			counter++;
			return ServerDetails.builder().serverIp(serverIp).build();
		}finally {// here we use finally because exception occurred or not we need to release the lock
			lock.unlock();
		}
	}
}
