package com.helpingduck.loadbalance;

import com.helpingduck.loadbalance.context.LoadBalanceContext;
import com.helpingduck.loadbalance.pool.IpPoolDetails;
import com.helpingduck.loadbalance.strategy.LoadBalance;
import com.helpingduck.loadbalance.strategy.impl.IpHashingLB;
import com.helpingduck.loadbalance.strategy.impl.RandomLB;
import com.helpingduck.loadbalance.strategy.impl.RoundRobinLB;
import com.helpingduck.loadbalance.strategy.impl.RoundRobinWeightedLB;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://medium.com/@wolfbang/load-balance-algorithm-with-java-e7fb55fe788a
 * https://turkogluc.com/java-concurrency-with-load-balancer-simulation/
 * https://www.programmersought.com/article/9953215699/
 */
public class ServerLoadBalancer {

	public static final ExecutorService executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		loadBalance();
	}
	public static void loadBalance() {

		try{

			for(int i =0 ; i < 10 ; i ++){

				executor.execute(() -> getServerDetails(new RoundRobinLB(IpPoolDetails.ips)));

				executor.execute(() -> getServerDetails(new RandomLB(IpPoolDetails.ips)));

				Random r = new Random();
				String randomUrl =
						r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);

				executor.execute(() -> getServerDetails(new IpHashingLB(randomUrl,IpPoolDetails.ips)));

				executor.execute(() -> getServerDetails(new RoundRobinWeightedLB(IpPoolDetails.weightIps)));
			}
		}finally {
			executor.shutdown();
		}
	}
	
	public static void getServerDetails(LoadBalance balance) {
		LoadBalanceContext balanceContext = new LoadBalanceContext(balance);
		System.out.println("Algo Name :" + balance.getClass().getSimpleName() +  "Request Name { " + Thread.currentThread().getName()  + " } " +  balanceContext.getServerDetails().getServerIp() );
	}
}
