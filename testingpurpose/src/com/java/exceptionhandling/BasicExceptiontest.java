package com.java.exceptionhandling;

import java.util.Map;

public class BasicExceptiontest {

	static boolean cleanUpUtil() {

		try {

			System.out.println("Clean up code is here ," + "if the cleanup also throw exception then");
			return true;

		} catch (Exception e) {

			System.out.println("Exception " + e);
			return false;
		}

	}

	public void helo() {

		try {
			int i = 10 / 0;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out.println("Finallly");
		}
		System.out.println("after Finallly");
	}

	public static void main(String[] args) throws CustomException  {

		BasicExceptiontest b = new BasicExceptiontest();
		
		b.helo();
		try {
			int a = 10 / 1;
			int[] arr = { 2, 3, 4 };

			arr[10] = 45;
			/*
			 * while(true) { System.out.println("aaa"); }
			 */// finally not execute

		}

		catch (ArithmeticException e) {

			System.out.println("Exception " + e);
			String j = null;
			// j.length();
			// System.exit(0);/// finally not execute
			// kill jvm
			// power failure
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("task 2 completed " + e);

		} catch (Exception e) {

			System.out.println("Exception2 " + e);
		}

		try {
			int i = 10 / 0;
		} catch (Exception e) {

			System.out.println("Exception3 " + e);
		}
		
		/* custom exception */

		try {
			String s = null;
			s.length();
		} catch (Exception e) {
			System.out.println("Custom Exception " + e);
			throw new CustomException("Null Pointer Exception is coming");
			
		}

		finally {

			System.out.println("working!!");

			cleanUpUtil();
			/*
			 * try { int i = 10/0; } finally { System.out.println("working!!"); }* // if u
			 * think finally may throw an exception then use this readable function
			 * 
			 */
			

		}
		

		//since we have throw the exception this statement will not execute line 81
		//line 81 ---> throw new CustomException("Null Pointer Exception is coming");
		System.out.println("not working!");

	}

}
