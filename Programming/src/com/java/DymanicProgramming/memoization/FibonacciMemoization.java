package com.java.DymanicProgramming.memoization;

public class FibonacciMemoization {

	/**
	 * Memorized Array
	 */
	long a [] = null;
	
	public long setArray(int n) {
		a  = new long[ n+1];
		for ( int i=0; i <n+1 ; i++){
		    a[i]= -1;
		}
		
		return fibo(n);
	}
	
	public long fibo(int n) {
		
		if(n == 0 || n == 1 ) {
			return a[n] = n;
		}else if(a[n] != -1 ) {
			return a[n];
		}else {
			a[n] =fibo(n-2) + fibo(n-1);
			return a[n];	
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FibonacciMemoization fib = new FibonacciMemoization();
		System.out.println(fib.setArray(10));
	}

}
