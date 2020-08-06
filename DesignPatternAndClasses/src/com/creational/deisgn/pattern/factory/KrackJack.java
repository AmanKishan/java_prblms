package com.creational.deisgn.pattern.factory;

public class KrackJack extends AbstractParleBisCuit {

	private String size;
	private String type;
	
	public KrackJack(String size , String type) {
	this.size = size;
	this.type = type;
	}
	
	@Override
	public String getSize() {
		return "20GM";
	}

	@Override
	public String getType() {
		return "Sweet-Saltly";
	}

}
