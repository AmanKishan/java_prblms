package com.java.exceptionhandling;

import java.io.IOException;

public class ParentException {

	
	public void print() throws CustomException {
		
		System.out.println("hiiiii");
		try {
			int i =10/0;
			
		}
		catch(ArithmeticException e) {
			throw new CustomException("Divide by zero exception", ErrorCode.ERROR_CODE1);
		}
		
	}
	
	protected void display() throws IOException
	{
		System.out.println("IOException");
	}
	
	public static void  print(int i) {
		System.out.println("Printing .. " + i);
	}
	
	
	
}
