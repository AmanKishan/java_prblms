package com.java.ArrayDS;

import java.util.Arrays;
import java.util.List;

public class SubArraySum {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(3,4,5,6,7,3,5,6,3,6,8,6);
		int sum = 16;
		int checkSum = 0;
		int startidx = 0;
		int endIdx = 0;
		boolean flag =false;
		for(int i = 0 ;i < intList.size()-1 ; i ++) {
			checkSum = checkSum +intList.get(i);
			 	
			endIdx = i;
			if(checkSum > sum) {
				checkSum = checkSum - intList.get(startidx);
			
				startidx++;
			}
			if(checkSum == sum) {
				flag =true;
						break;	
						}
			
			
		}
		System.out.println(flag == true ? "Start index :" + startidx + " and End index : " +  endIdx  : "Sum not found");
	}

}
