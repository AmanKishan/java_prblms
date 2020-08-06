package com.creational.deisgn.pattern.factory.abstractfacory;

public class CrackJackFactory extends AbstractBiscuitFactory{

	
	private String size;
	private String type;

	
	public CrackJackFactory(String size , String type) {
		this.size = size;
		this.type = type;
	}
	@Override
	public AbstractBisCuit createBiscuit() {

		return new CrackJack(size, type);
	}

	
}
