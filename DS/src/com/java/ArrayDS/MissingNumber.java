package com.java.ArrayDS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MissingNumber {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,4,6);
		int n =6;
		int sum = 0;
		/*for(int i =1 ; i <= n;i++ ) {
			sum = sum + i;
		}*/
		sum = IntStream.range(1, n+1).sum();
		System.out.println(sum);
		int sumList = intList.stream().mapToInt(i->i.intValue()).sum();
		
		System.out.println("Missing number : " + (sum - sumList));
		
	}
}
