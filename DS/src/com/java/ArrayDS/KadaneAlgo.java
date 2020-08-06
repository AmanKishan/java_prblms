package com.java.ArrayDS;

import java.util.Arrays;
import java.util.List;

/**
 * program to find the sum of contiguous sub-array within a 
 one-dimensional array of numbers which has the largest sum
 * */
public class KadaneAlgo {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(1,2,3,-2,-3,-1,-2,4,0,-2,-1,8);//9 is the answer
		
		int max_end = 0;
		int max_so_far = Integer.MIN_VALUE;
		for(Integer i : intList) {
			max_end = max_end + i;
			if(max_so_far < max_end)
				max_so_far = max_end;
			if(max_end < 0)
				max_end =0;
			
		}
		

		System.out.println(max_so_far);
	}

}
