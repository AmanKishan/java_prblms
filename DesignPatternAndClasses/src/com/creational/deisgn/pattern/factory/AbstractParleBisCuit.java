package com.creational.deisgn.pattern.factory;

public abstract class AbstractParleBisCuit {


	/**
	 * 
	 * 10 gm, 20 gm , 100gm etc
	 */
	public abstract String getSize();
	/**
	 * salted / sweet / salted-sweet / nigger(no taste)  
	 */
	public abstract String getType();
	@Override
	public String toString() {
		return "BisCuit Size=" + this.getSize() + ", Type=" + this.getType() + "]";
	}
	
	
	
}
