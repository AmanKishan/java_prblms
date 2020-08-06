package com.java.interfaceq;

public interface InterfaceC  extends InterfaceB,InterfaceA {

	void foo();
	
	default void fooDefault() {
		System.out.println("InterfaceC Default");
		
	} 
}
