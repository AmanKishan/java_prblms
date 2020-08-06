package com.java.inheritance;

public class SubClass extends SuperClass {

	public void print() {
		System.out.println("Inside Subclass class print method");
	}
	
	public static void display() {//compile time binding 
		System.out.println("Inside Subclass class static method display method");
	}
	
	private  void privatePrint() {//compile time binding 
		System.out.println("Inside Super class private print method");
	}
	
	
	public static void main(String[] args) {
		SuperClass superclass = new SubClass();
		superclass.print();
		superclass.display();
		//superclass.privatePrint();//CTE not visible
		
	}
}
