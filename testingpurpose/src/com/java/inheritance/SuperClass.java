package com.java.inheritance;

public class SuperClass {

	public void print() {
		System.out.println("Inside Super class print method");
	}
	
	public static void display() {//compile time binding 
		System.out.println("Inside super class static method display method");
	}
	
	private  void privatePrint() {//compile time binding 
		System.out.println("Inside Super class private print method");
	}
}
