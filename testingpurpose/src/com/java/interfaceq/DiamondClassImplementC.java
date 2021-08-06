package com.java.interfaceq;

public class DiamondClassImplementC implements InterfaceC{

	@Override
	public void foo() {
		System.out.println("Diamond class");
	}
	
	public static void main(String[] args) {
		InterfaceA d = new DiamondClassImplementC();
		d.fooDefault();//Rule 2 it print InterfaceC Default because its has high preference than A and B 
	}

}
