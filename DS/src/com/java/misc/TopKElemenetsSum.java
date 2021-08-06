package com.java.misc;

import java.util.PriorityQueue;

public class TopKElemenetsSum {

	public static void main(String[] args) {
		
		
		int arr1[] = {4,8,11,2,18,23,16};
		int arr[] = {12,16,11,1,2,3};
		int k = 3;
		System.out.println(topKElementSum(arr,k));

	}
	
	public static int topKElementSum(int arr[], int k ) {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for(int i : arr) {
			priorityQueue.add(i);
			if(priorityQueue.size() > k) {
				priorityQueue.poll();

			}
		}
		
	    return priorityQueue.stream().reduce((a,b) -> a+b).orElse(0);
	    
	}
	
}







