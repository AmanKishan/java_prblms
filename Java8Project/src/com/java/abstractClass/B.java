package com.java.abstractClass;

public class B extends A {

	
	public static  void test() {
		System.out.println("B test");
	}
	
	public static void main(String[] args) {
		A a = new B();
		a.test();
		
	}
}
