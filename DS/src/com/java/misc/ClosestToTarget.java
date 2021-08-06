package com.java.misc;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

///This question is asked in wipro interview
public class ClosestToTarget {

	public static void main(String[] args) {

		
		int arr[] = {2,3,5,6,-3,8,9,17};
		int target = 14;
		System.out.println(closestToTarget(arr,target));
		
		
		ThreadLocalRandom rand =  ThreadLocalRandom.current();
        String str =  String.format( //don't want any thousand separators
                "%04d-%04d-%04d-%04d",
                rand.nextInt(100),
                rand.nextInt(10000),
                rand.nextInt(10000),
                rand.nextInt(10000));
	          
	          System.out.println(str);
	        
	}
	
	public static int closestToTarget(int arr[], int target) {
		
		int min = Integer.MAX_VALUE;
		int value = -1;
		for(int i =0 ; i < arr.length ;i ++) {
			
			int temp = Math.abs(target- arr[i]);
			
			if(temp ==0 ) {
				return arr[i];
			}
			if(temp < min) {
				
				min = temp;
				value = arr[i];
			}
			
		}
		return value;
	}

}
