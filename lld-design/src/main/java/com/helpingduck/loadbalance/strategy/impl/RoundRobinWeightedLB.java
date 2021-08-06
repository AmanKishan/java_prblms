package com.helpingduck.loadbalance.strategy.impl;

import com.helpingduck.loadbalance.model.ServerDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoundRobinWeightedLB extends  RoundRobinLB {

    public RoundRobinWeightedLB(final Map<String,Integer> ipsMap){
        super(ipsMap.entrySet().stream().map(entrySet -> {
            List<String> tempList =  new LinkedList<>();
            String key = entrySet.getKey();
            for(int i = 0 ; i < entrySet.getValue() ; i++){
                tempList.add(key);
            }
            return tempList;
        }).flatMap(Collection::stream).collect(Collectors.toList()));
    }

    @Override
    public ServerDetails getServerDetails() {
        return super.getServerDetails();
    }
}
