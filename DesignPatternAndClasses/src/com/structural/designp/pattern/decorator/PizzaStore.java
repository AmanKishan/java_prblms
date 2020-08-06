package com.structural.designp.pattern.decorator;


/**
 * {@link } https://www.geeksforgeeks.org/decorator-pattern-set-3-coding-the-design/?ref=lbp
 * @author arastogi
 *
 */
public class PizzaStore {

	public static void main(String[] args) {
		
		Pizza farmHouse = new FarmHouse(); 
		
		System.out.println(farmHouse.getDescription() + " cost is : " + farmHouse.getCost());
		farmHouse = new MashroomDecorator(farmHouse);
		
		System.out.println(farmHouse.getDescription() + " cost is : " + farmHouse.getCost());
		
		
		farmHouse = new CheezBrustDecorator(farmHouse);
		
		System.out.println(farmHouse.getDescription() + " cost is : " + farmHouse.getCost());
	}
}
