package com.creational.deisgn.pattern.factory;

public class ParleG extends AbstractParleBisCuit {

	
	private String size;
	private String type;
	
	public ParleG(String size , String type) {
	this.size = size;
	this.type = type;
	}
	
	@Override
	public String getSize() {
		
		return "100Gm";
	}

	@Override
	public String getType() {
		
		return "Sweet";
	}

}
