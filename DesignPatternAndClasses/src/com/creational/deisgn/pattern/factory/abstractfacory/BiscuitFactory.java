package com.creational.deisgn.pattern.factory.abstractfacory;

public class BiscuitFactory {

	public static AbstractBisCuit getBiscuit(AbstractBiscuitFactory biscuitAbstractFactory) {
		return biscuitAbstractFactory.createBiscuit();
	}
	
	
	public static void main(String[] args) {
		
		AbstractBisCuit crackjack = BiscuitFactory.getBiscuit(new CrackJackFactory("20GM", "Sweet-Saltly"));
		AbstractBisCuit goodDay = BiscuitFactory.getBiscuit(new GoodDayFactory("50GM", "Sweet"));
		
		System.out.println("crackjack " + crackjack.getSize() + " " + crackjack.getType());
		System.out.println("goodDay " + goodDay.getSize() + " " + goodDay.getType());
	}
}
