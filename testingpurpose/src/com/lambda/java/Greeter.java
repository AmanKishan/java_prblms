package com.lambda.java;

public class Greeter {

	public void greet(Greeting greeting) {

		greeting.perform();
		greeting.printName();
	}
	
	public static void main(String[] args) {

		Greeter greeter = new Greeter();
		Greeting greeting = new GreetingHelloWorld();
		greeter.greet(greeting);
		Greeting helloworld = ()->System.out.println("Hello world using lambda with variable contain function!");
		greeter.greet(helloworld);
		greeter.greet(()->System.out.println("Hello world using pure lambda!"));

	}

}
