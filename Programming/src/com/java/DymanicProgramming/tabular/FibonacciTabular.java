package com.java.DymanicProgramming.tabular;

public class FibonacciTabular {

	long a [] = null;
	
	public long setArray(int n) {
		a  = new long[ n+1];
		a[0] = 0;
		a[1] =1;
		
		return fibo(n);
	}
	
	private long fibo(int n) {
		
		if(n == 0) return 0;
		else if(n == 1 ) return 1;
		else {
			for(int i = 2 ; i <= n ;i++ ) {
				a[i] = a[i-1] + a[i-2];
				
			}
		}
		return a[n];
	}

	public static void main(String[] args) {
		
		FibonacciTabular fib = new FibonacciTabular();
		System.out.println(fib.setArray(1000));
	}
}
