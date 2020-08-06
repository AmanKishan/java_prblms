package com.structural.designp.pattern.flyweight;

public class Terrorist implements Player {
	// intrinsic attribute
	private String task;

	// extrinsic attribute
	private String weapon;

	public Terrorist() {
		this.task = "Place bomb";
	}

	@Override
	public void assignWeapon(String weapon) {
		this.weapon = weapon;
	}

	@Override
	public void mission() {

		System.out.println("Terrorist with weapon" + weapon + " and have task " + task);
	}


}
