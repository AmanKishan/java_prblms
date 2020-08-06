package com.java.interfaceq;

public class ClassDExtendsC extends CLassC implements InterfaceA,InterfaceB {

	@Override
	public void foo() {
	System.out.println("ClassDExtendsC foo");
		
	}
	
	//this will prinnt Class C Default since class has high preference
	public static void main(String[] args) {
		InterfaceB a = new ClassDExtendsC();
		a.fooDefault();
	}
}
