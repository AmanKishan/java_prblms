package com.creational.deisgn.pattern.factory.abstractfacory;

public class CrackJack extends AbstractBisCuit {

	private String size;
	private String type;
	
	public CrackJack(String size , String type) {
	this.size = size;
	this.type = type;
	}
	
	@Override
	public String getSize() {
		return this.size;
	}

	@Override
	public String getType() {
		return this.type;
	}

}
