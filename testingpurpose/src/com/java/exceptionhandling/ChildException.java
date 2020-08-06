package com.java.exceptionhandling;

import java.io.IOException;

public class ChildException  extends ParentException{
/*
	@Override
	public void print() throws IOException{ //CT Error //no checked exception allowed
		System.out.println("hello");
	
	}
	*/
	
	//for checked exception we can throws runtimeException in child
	//for uncheked exception we cann't throws checked exception in child
	@Override
	protected void display() throws RuntimeException{
		System.out.println("ArithmeticException");
	}
	
	@Override
	public void print() throws ArithmeticException{
		System.out.println("hello");
		try {
		
			throw new java.lang.OutOfMemoryError("this is  bad practice  in java");
		}
		catch(Error e) {
			System.out.println("Error is catchable "  + e);
		}
		
		
		finally {
		
			System.out.println("hi finally 1");
		}
		
		
		System.out.println("hello reachable code");
		
	
		
		try {
			
			throw new java.lang.Error("this is very bad request");
		}
		catch(OutOfMemoryError e) {
			System.out.println("OutOfMemoryError is catchable "  +e);
		}
		
		
		finally {
		
			System.out.println("hi finally 2");
		}
		
		
		System.out.println("hello not reachable code");//due to line 37
	}
	
	
	public static void  print(int i) {
		System.out.println("Printing .. " + i*2);
	}
	
	
	public static void main(String[] args) throws CustomException, IOException {

		ParentException p = new ChildException();
		p.display();
		p.print();
		p.print(6);//hiding child method
		
		
	}

}
