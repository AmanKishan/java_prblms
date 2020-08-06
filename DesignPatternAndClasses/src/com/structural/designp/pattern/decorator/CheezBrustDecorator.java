package com.structural.designp.pattern.decorator;

public class CheezBrustDecorator extends ToppingDecorator {

	Pizza pizza;

	public CheezBrustDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		
		return pizza.getDescription() + " Added Toping is Cheez brust";
	}

	@Override
	int getCost() {
		return pizza.getCost() + 50;
	}

}
