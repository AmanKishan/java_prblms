package com.helpingduck.loadbalance.strategy.impl;

import com.helpingduck.loadbalance.model.ServerDetails;
import com.helpingduck.loadbalance.strategy.LoadBalance;

import java.util.List;
import java.util.Random;

public class RandomLB extends LoadBalance {

	public RandomLB(List<String> serversList){
		super(serversList);
	}

	@Override
	public ServerDetails getServerDetails() {

		Random ram = new Random();
		String serverIp= super.serversList.get(ram.nextInt(super.serversList.size()));
		return ServerDetails.builder().serverIp(serverIp).build();
	}
}
