package com.java.exceptionhandling;

import java.io.IOException;

import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;

public class CompileTimePropagation {

	
	void m() {
		try {
			n();
			
			
			
		}
		catch(Exception e) {
			
			System.out.println("Exception "  + e);
			
		}
		
		finally {
			System.out.println("Hello1 ");
		}
		
		//another
		
		try {
			n();
			
			
			
		}
		catch(Exception e) {
			
			System.out.println("Exception "  + e);
			
		}
		
		finally {
			System.out.println("Hello 2");
		}
		
	}	
	
	void n() throws IOException  {

		
		throw new IOException("hello");
	
		
	}

	void n(int a){

	
		int i = 10/0;
		
		
	}
	public static void main(String[] args) {

		
		CompileTimePropagation c = new CompileTimePropagation();
		c.m();
	}

}
