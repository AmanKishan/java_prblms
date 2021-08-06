package com.helpingduck.loadbalance.strategy;

import java.util.Arrays;
import java.util.List;

public class MockData {

    private MockData(){}

    public static List<String> getMockServers(){
        return Arrays.asList("192.168.1.1","192.168.1.2","192.168.1.3","192.168.1.4","192.168.1.5");
    }

    public static List<String> getNotPresentMockServers(){
        return Arrays.asList("192.168.1.100","192.168.1.200");
    }

    public static String getIpHashExpectedServerDetails(String clientIp){
        return getMockServers().get(Math.abs(clientIp.hashCode() % getMockServers().size()));
    }
}
