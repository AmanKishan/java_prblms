package com.helpingduck.loadbalance.context;

import com.helpingduck.loadbalance.model.ServerDetails;
import com.helpingduck.loadbalance.strategy.LoadBalance;

public class LoadBalanceContext {

	private LoadBalance loadBalance;
	
	public LoadBalanceContext(LoadBalance loadBalance){
		this.loadBalance = loadBalance;
	}
	
	public ServerDetails getServerDetails() {
		return this.loadBalance.getServerDetails();
	}
}
