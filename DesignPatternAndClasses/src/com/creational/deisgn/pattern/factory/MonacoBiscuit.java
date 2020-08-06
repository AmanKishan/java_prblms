package com.creational.deisgn.pattern.factory;

public class MonacoBiscuit extends AbstractParleBisCuit {

	private String size;
	private String type;
	
	public MonacoBiscuit(String size , String type) {
	this.size = size;
	this.type = type;
	}
	
	@Override
	public String getSize() {
		return "50Gm";
	}

	@Override
	public String getType() {
		
		return "Salted";
	}

}
