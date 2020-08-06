package com.java.String;

public class SumOfAllSubString {

	
	public static int sum(String digit) {
	
	int length = digit.length();
	int sum = 0 ;
	if(length == 0) return 0;	
	for(int i = digit.length(); i > 0 ; i-- ) {
		sum = sum + Integer.parseInt(digit.substring(0, i));
		
	}
	
	return sum + sum(digit.substring(1, length));
	
	}
	
	public static void main(String[] args) {

		System.out.println(SumOfAllSubString.sum("123"));
	}

}
