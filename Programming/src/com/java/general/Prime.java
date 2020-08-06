package com.java.general;

import java.util.stream.IntStream;

public class Prime {

	
	public boolean isPrime(int num) {
		boolean flag = true;
		for(int i =2 ; i< num/2 ;i++) {
				if(num % i == 0) {
					flag = false;
					break;
				}
		}
		
		
		return flag;
		
	}
	
	
	public boolean isPrimeJava8(int num) {
	//return IntStream.rangeClosed(2, num/2).anyMatch(i -> num%i ==0 );
	return java.math.BigInteger.valueOf(num).isProbablePrime(1);
		      
	}
	
	 PerformOperation isPrimeLambda(){
	     return (int num) -> !IntStream.rangeClosed(2, num/2).anyMatch(i -> num%i ==0 );      
	    }
	
	public static void main(String[] args) {
		
		Prime p = new Prime();
		System.out.println(p.isPrimeLambda().check(5));
		
		
	}
}

interface PerformOperation {
	 boolean check(int a);
	}
