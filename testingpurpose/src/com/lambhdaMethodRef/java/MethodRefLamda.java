package com.lambhdaMethodRef.java;

import java.util.Arrays;
import java.util.List;

public class MethodRefLamda {

	
	public MethodRefLamda() {
		System.out.println("inside constructor");
	}
	public static void main(String[] args) {

		List<String> list = Arrays.asList(
				"aman","mausam","lakshit"
				);
		list.forEach(s->System.out.println(s));//without method ref
		
		list.forEach(System.out::println);//with method ref syntax : Object :: Function
		
		/*invoke static method*/
		Thread t = new Thread(()->printStatic());//replace this by method references
		Thread t2 = new Thread(MethodRefLamda::printStatic);
		
		/*invoke instance method*/
		Thread t3 = new Thread(()->new MethodRefLamda().printInstance());//replace this by method references
		Thread t4 = new Thread(new MethodRefLamda()::printInstance);
		
		/*invoke constructor*/
		Thread t5 = new Thread(new MethodRefLamda().toString());
		
		t.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	
	 void  printInstance() {
		System.out.println("hello print instance");
	}
	 
	 static void  printStatic() {
			System.out.println("hello print static ");
		}

}
