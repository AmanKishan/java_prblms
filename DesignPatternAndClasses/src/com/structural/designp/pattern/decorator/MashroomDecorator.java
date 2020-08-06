package com.structural.designp.pattern.decorator;

public class MashroomDecorator extends ToppingDecorator {

	Pizza pizza;

	public MashroomDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " Added Topping is Mashroom" ;
	}

	@Override
	int getCost() {
		
		return pizza.getCost() + 20;
	}

}
