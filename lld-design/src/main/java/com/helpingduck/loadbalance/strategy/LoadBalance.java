package com.helpingduck.loadbalance.strategy;

import com.helpingduck.loadbalance.model.ServerDetails;

import java.util.List;

public abstract class LoadBalance {

    // reason for choosing abstract class over interface bcoz here I need to use
    // serversList as a common factor for all my child classes
    // refer RoundRobinWeightedLB class for more clarification
    public final List<String> serversList;

    public LoadBalance(List<String> serversList){

        this.serversList = serversList;
    }

    public abstract ServerDetails getServerDetails();
}
