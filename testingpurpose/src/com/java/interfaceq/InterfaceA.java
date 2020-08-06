package com.java.interfaceq;

public interface InterfaceA {

	void foo();
	default void fooDefault() {
		System.out.println("InterfaceA Default");
	} 
}
