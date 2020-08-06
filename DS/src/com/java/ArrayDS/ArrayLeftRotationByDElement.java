package com.java.ArrayDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLeftRotationByDElement {

	static void  leftRotateOnebyOne(List<Integer> intList , int n , int d) {
		System.out.println("Before rotation : " + intList);
		for(int j = 0 ; j < d ; j++ ) {
			int temp = intList.get(0);
			
			for(int i = 0 ;i < n-1 ;i ++) {
				
				intList.set(i, intList.get(i+1));
				
			}
			intList.set(n-1, temp);
			System.out.println("Iteration " + j + " : " + intList);
		}
		
		System.out.println("After rotation : " + intList);
	}

	
	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1,2,6,7,8);
		int d = 1;//rotate y 3 elements
		leftRotateOnebyOne(intList,intList.size(),d);
		//leftRotateJuggingAlgo(intList,intList.size(),d);
		System.out.println(gcd(3,45));
		System.out.println(lcm(6,45));
		System.out.println(lcmWidoutGcd(6,45));
		System.out.println(6%45);

	}

	/**
	 * HCF(Highest common factor/Greatest Common Multiple)
	 * @param d
	 * @param n
	 * @return
	 */
	static int gcd(int d , int n) {
		if(n == 0 || d == 0)
			return d;
		else 	
			return gcd(n , d%n);
	}
	
	static int lcm(int d , int n) {
		return d*n / gcd(d,n);
	}
	
	static int lcmWidoutGcd(int d , int n) {
		int min = Math.min(d, n);
		int max = Math.max(d, n);
		int i = max;
		while(true) {
			if(i % min == 0) {
				return i;
			}
			i = i+max;
		}
	}
	
	static void leftRotateJuggingAlgo(List<Integer> intList , int n , int d) {
		
		int gcd = gcd(n,d);
		int i,j,k,temp;
		for( i = 0; i < gcd ;i++) {
			temp = intList.get(i);
			j = i;
			System.out.println(intList);
			while(true) {
				k = j+d;
				if(k >= n) {
					k = k -n;
				}
				if(k ==i ) {
					break;
				}
				intList.set(j, intList.get(k));
				j = k;
				System.out.println(intList);
			}
			intList.set(j, temp);
			System.out.println(intList);
		}
		//System.out.println(intList);
	}
}
