package com.creational.deisgn.pattern.factory.abstractfacory;

public class GoodDayFactory extends AbstractBiscuitFactory{


	private String size;
	private String type;

	
	public GoodDayFactory(String size , String type) {
		this.size = size;
		this.type = type;
	}
	@Override
	public AbstractBisCuit createBiscuit() {

		return new CrackJack(size, type);
	}

}
