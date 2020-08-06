package com.creational.deisgn.pattern.factory.abstractfacory;

public class GoodDay extends AbstractBisCuit {

	private String size;
	private String type;
	
	@Override
	public String getSize() {
		return this.size;
	}

	@Override
	public String getType() {
		return this.type;
	}

}
