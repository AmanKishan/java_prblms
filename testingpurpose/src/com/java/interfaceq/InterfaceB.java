package com.java.interfaceq;

public interface InterfaceB {

	void foo();
	

	default void fooDefault() {
		System.out.println("InterfaceB Default");
	} 
}
