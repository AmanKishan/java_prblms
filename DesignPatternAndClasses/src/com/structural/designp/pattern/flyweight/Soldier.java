package com.structural.designp.pattern.flyweight;

public class Soldier implements Player {

	// intrinsic attribute
	private String task;

	// extrinsic attribute
	private String weapon;

	public Soldier() {
		this.task = "Diffuse bomb";
	}

	@Override
	public void assignWeapon(String weapon) {
		this.weapon = weapon;
	}

	@Override
	public void mission() {

		System.out.println("Soldier with weapon" + weapon + " and have task " + task);
	}

}
