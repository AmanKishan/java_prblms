package com.java.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResource {
	
	
	public static void main(String[] args) {
		
		check();
	}
	
	/**
	 * try catch and finally
	 */
	public void tryCatchFinally(){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("/users/aman/a.txt"));
			
			//Do something
		}
		//NO statement here
		catch(FileNotFoundException e ) {
			//handling exception
		}	
		//multiple catch are allowed
		//NO statement here
		finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		//Only one finally is allowed
		
	}
	
	/**
	 * try and finally
	 */
	public void tryFinally() {
		try {
			//some 
		}
		finally {
			//do something 
		}
	}

	/**
	 * try with resources
	 */
	
	public void tryWithResources() {
		
	}
	
	/**
	 * 
	 */
	public static void check(){
	     try{
	         System.out.println("First statement of try block");
	         int num=45/0;
	         System.out.println(num);
	      }
	      catch(ArrayIndexOutOfBoundsException e){
	    	  //Control will not come here bcoz is a divide by zero ArithmeticException
	         System.out.println("ArrayIndexOutOfBoundsException");
	      }
	     catch(ArithmeticException e) {
	    	 System.out.println("ArithmeticException ---->");
	     }
	      finally{
	         System.out.println("finally block");
	      }
	      System.out.println("Out of try-catch-finally block");
	    }
}
