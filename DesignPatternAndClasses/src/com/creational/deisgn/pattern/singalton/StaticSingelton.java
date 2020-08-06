package com.creational.deisgn.pattern.singalton;

public class StaticSingelton {

	private static final StaticSingelton staticSingeltonObj;

	private StaticSingelton() {

	}

	static {
		staticSingeltonObj = new StaticSingelton();
	}

	public static StaticSingelton getSingeltonObject() {

		return staticSingeltonObj;
	}
}
