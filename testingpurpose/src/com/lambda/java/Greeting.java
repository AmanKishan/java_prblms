package com.lambda.java;

public interface Greeting {
	
	public void perform();
	
	default void printName() {
		System.out.println("Greeting!!");
	}

	
	static void helloWorld() {
		System.out.println("Hello world Greeting");
	}
}
