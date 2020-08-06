package com.java.defaultMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CheckDefaultClass implements CheckDefault, CheckDefault2{

	static  final  int num; 
	 final int num2;
	 {
		 System.out.println("code initializer");
		 num2 =9;
		 System.out.println(num2);
		 
			
	 }	
	 static  {
		 System.out.println("static initializer");
		 num = 7;
		 System.out.println(num);
	 }
	 
	 CheckDefaultClass(){
		 System.out.println("default constructor");
		//num2 =9; 
		
	 }
	 
	 
	public static void main(String[] args) {
		System.out.println("Main class is loaded");
		CheckDefault c = new CheckDefaultClass();
		c.hello();
		
		
		Map<String,Integer> m = new HashMap<>();
		m.put("abc",1);
		m.put("abd",2);
		m.put("acc",3);
		m.put("abc",5);
		m.put(new String("abd"),7);
		System.out.println(m);
		
	}

	/**
	 * implement calling CheckDefault2 default hello method
	 */
	@Override
	public void hello() {
		
		CheckDefault2.super.hello();
		CheckDefault.super.hello();
		
		
	}

	
	
}
