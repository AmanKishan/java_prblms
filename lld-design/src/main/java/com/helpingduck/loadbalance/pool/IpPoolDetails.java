package com.helpingduck.loadbalance.pool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IpPoolDetails {

	//Map IP and Weight
	public static Map<String, Integer> weightIps = new ConcurrentHashMap<>();
	public static List<String> ips;
	
	static {

		ips = Arrays.asList("192.168.1.1","192.168.1.2","192.168.1.3","192.168.1.4","192.168.1.5");

		weightIps.put("192.168.1.1", 5);
		weightIps.put("192.168.1.2", 10);
		weightIps.put("192.168.1.3", 10);
		weightIps.put("192.168.1.4", 8);
		weightIps.put("192.168.1.5", 7);
		weightIps.put("192.168.1.6", 14);
		weightIps.put("192.168.1.7", 12);
	}
}
