package com.lambda.java;

public interface Greeting2 {
	
	public void perform();
	
	default void printName() {
		System.out.println("Greeting2!!");
	}
	
	static void helloWorld() {
		System.out.println("Hello world Greeting2");
	}

}
