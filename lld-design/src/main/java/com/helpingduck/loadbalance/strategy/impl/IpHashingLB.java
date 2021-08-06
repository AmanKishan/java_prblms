package com.helpingduck.loadbalance.strategy.impl;

import com.helpingduck.loadbalance.model.ServerDetails;
import com.helpingduck.loadbalance.strategy.LoadBalance;

import java.util.List;

public class IpHashingLB extends LoadBalance {

	private String clientIp;

	public IpHashingLB(String clientIp,List<String> serversList){
		super(serversList);
		this.clientIp = clientIp;
	}

	@Override
	public ServerDetails getServerDetails() {
		if(this.clientIp == null) this.clientIp = "127.0.0.1";
		int hashIdx =  Math.abs(this.clientIp.hashCode() % super.serversList.size()); // hashCode may come as negative
		return ServerDetails.builder().serverIp(super.serversList.get(hashIdx)).build();
	}
}
