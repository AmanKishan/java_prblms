package com.structural.designp.pattern.flyweight;

import java.util.Random;
import java.util.stream.IntStream;
/**
 * 
 * {@link} https://www.geeksforgeeks.org/flyweight-design-pattern/
 * @author aman_rastogi
 *
 */
public class Fight {

	private static String[] playerType = {"Terrorist","Soldier"};
	private static String[] weapons =  {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};
	
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(i ->{
			 Player p = PlayerFactory.getPlayer(getRandom());
			 p.assignWeapon(getRandWeapon());
			 p.mission();
		});
	}
	
	public static String getRandom() {
		
		Random r = new Random(); 
		int randInt = r.nextInt(playerType.length); 
        return playerType[randInt]; 
		
	}
	  public static String getRandWeapon() 
	    { 
	        Random r = new Random(); 
	        int randInt = r.nextInt(weapons.length); 
	        return weapons[randInt]; 
	    } 
}
