package com.structural.designp.pattern.flyweight;

import java.util.HashMap;

public class PlayerFactory {

	public static HashMap<String,Player> map = new HashMap<>();
	
	public static Player getPlayer(String type) {
		
		Player p = null;
		
		if(map.containsKey(type)) {
			p = map.get(type);
		}else {
			switch(type) {
			case "Terrorist":
				System.out.println("Create Terrorist");
				p = new Terrorist();
				break;
			case "Soldier":
				System.out.println("Create Soldier");
				p = new Soldier();
				break;
			default :
				System.out.println("Wrong Choice");
			}
			map.put(type, p);
		}
		
		return p;
	}
}
