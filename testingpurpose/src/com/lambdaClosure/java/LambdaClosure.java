package com.lambdaClosure.java;

public class LambdaClosure {

	

	public static void main(String[] args) {

		int a = 10;
		int b= 20;
		doProcess(a, i->System.out.println(a+b));
		
	}

	private static void  doProcess(int i , Process p) {
		p.process(i);
	}
}

@FunctionalInterface
interface Process{
	void process(int i);
}