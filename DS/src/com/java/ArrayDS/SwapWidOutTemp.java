package com.java.ArrayDS;

public class SwapWidOutTemp {

	
	public static void swapInt(int a, int b) {
		System.out.println("Before swap" + " a = " + a + " and b = " + b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("After swap" + " a = " + a + " and b = " + b);

	}
	
	public static void swapString(String a , String b) {

		System.out.println("Before swap" + " a = " + a + " and b = " + b);
		
		a = a + b;
		b = a.substring(0, b.length()-1);
		a = a.substring(b.length() , a.length());
		System.out.println("After swap" + " a = " + a + " and b = " + b);
		
	}
	public static void main(String[] args) {
		
		SwapWidOutTemp.swapInt(8, 10);
		SwapWidOutTemp.swapString("Aman", "Akash");

	}

}
