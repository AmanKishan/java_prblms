package com.structural.designp.pattern.decorator;

public class FarmHouse extends Pizza {

	@Override
	String getDescription() {
		
		return "Farm House Pizza";
	}

	@Override
	int getCost() {
		return 100;
	}

}
