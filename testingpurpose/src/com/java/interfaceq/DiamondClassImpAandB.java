package com.java.interfaceq;

public class DiamondClassImpAandB implements InterfaceA, InterfaceB {

	@Override
	public void foo() {
	
		System.out.println("DiamondClassImpAandB");
	}

	//You have to give specific implementation of default method if both class have same methods 
	
	@Override
	public void fooDefault() {

		InterfaceA.super.fooDefault();    
		InterfaceB.super.fooDefault();
		
	}

	public static void main(String[] args) {
		DiamondClassImpAandB d = new DiamondClassImpAandB();
		//d.foo();
		d.fooDefault();
	}

}
