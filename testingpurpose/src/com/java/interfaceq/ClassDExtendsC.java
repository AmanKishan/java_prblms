package com.java.interfaceq;

public class ClassDExtendsC extends CLassC implements InterfaceA,InterfaceB {

	@Override
	public void foo() {
	System.out.println("ClassDExtendsC foo");	
	}
	
	@Override
	public void fooDefault() {
	
		super.fooDefault();// here you can call the parent class method
		System.out.println("ClassDExtendsC fooDefault");	
	}
	
	 public void protectedFoo() {
		System.out.println("ClassDExtendsC protectedFoo");
	}
	
	
	
	
	public static void main(String[] args) {
		InterfaceA a = new ClassDExtendsC();
		a.foo(); 
		a.fooDefault();// this its will call child class fooDefault and give more preference to class than interface
		
		
		CLassC c = new ClassDExtendsC();
		
		//This will print ClassDExtendsC -- (child class) method, since its override in child class 
		c.fooDefault();
		c.protectedFoo();
		
	}
}
