package com.java.misc;

import java.util.HashSet;
import java.util.Set;

public class CheckPairOfSumPresent {

	public static void main(String[] args) {
		
		int arr[] = {4,5,7,9,10,8};
		int sum =17;
		System.out.println(checkPairSum(arr,sum));

	}
	
	public static boolean checkPairSum(int[] arr, int sum) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < arr.length ;i ++) {
			
			int temp= sum - arr[i];
			if(set.contains(temp)){
				return true;
			}
			
			set.add(arr[i]);
			
		}
		return false;
	}
}
