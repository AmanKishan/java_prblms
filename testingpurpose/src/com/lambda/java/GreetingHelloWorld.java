package com.lambda.java;

public class GreetingHelloWorld implements Greeting,Greeting2 {

	
	@Override
	public void perform() {
		
		System.out.println("Hello World using classical object oriented!!");
	}

	@Override
	public void printName() {
		Greeting.super.printName();
		Greeting2.super.printName();
		//Greeting.printName();//CT 
	}
	
	private void hi() {
	
		Greeting.helloWorld();//static method interface no need to implemetn it

	}
	
}
