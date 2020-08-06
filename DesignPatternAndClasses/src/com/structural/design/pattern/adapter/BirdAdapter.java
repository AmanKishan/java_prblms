package com.structural.design.pattern.adapter;

/**
 * {@link} https://www.geeksforgeeks.org/adapter-pattern/
 * @author aman_rastogi
 *
 */
public class BirdAdapter implements ToyDuck {

	private Bird bird;

	public BirdAdapter(Bird bird) {
		this.bird = bird;
	}

	@Override
	public void squeak() {

		bird.makeSound();

	}

	public static void main(String[] args) {

		Sparrow sparrow = new Sparrow();
		ToyDuck toyDuck = new PlasticToyDuck();
		ToyDuck birdAdapter = new BirdAdapter(sparrow);
		System.out.println("Sparrow...");
		sparrow.fly();
		sparrow.makeSound();
		System.out.println("ToyDuck...");
		toyDuck.squeak();

		// toy duck behaving like a bird
		System.out.println("BirdAdapter...");
		birdAdapter.squeak();
	}
}
