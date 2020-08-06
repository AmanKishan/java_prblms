package com.creational.deisgn.pattern.builder;


/**
 * 
 * @author aman_rastogi
 *@Link https://www.journaldev.com/1425/builder-design-pattern-in-java
 *@link https://www.geeksforgeeks.org/builder-pattern-in-java/
 *@link https://stackoverflow.com/questions/328496/when-would-you-use-the-builder-pattern
 */

public final class ParleBiscuitClass {

	/* required */
	private String size;
	private String type;

	/* optional */

	private float price;

	private ParleBiscuitClass(ParleBuilder builder) {
		this.size = builder.size;
		this.type = builder.type;
		this.price = builder.price;
	}

	public static class ParleBuilder {

		/* required */
		private String size;
		private String type;

		/* optional */

		private float price;

		public ParleBuilder(String size, String type) {

			this.size = size;
			this.type = type;
			
		}
		
		/**
		 * Set optional params
		 */
		
		public ParleBuilder setPrice(float price) {
			this.price = price;
			return this;
		}
		
		/**
		 * return factory of ParleBiscuitClass
		 */
		 
		public ParleBiscuitClass build() {
			return new ParleBiscuitClass(this);
		}
		
	}

	
	@Override
	public String toString() {
		return "ParleBiscuitClass [size=" + size + ", type=" + type + ", price=" + price + "]";
	}


	/**
	 * 
	 * Test Parle builder  
	 */
	public static void main(String[] args) {
		ParleBiscuitClass parleBiscuitClass = new ParleBiscuitClass.ParleBuilder("20Gm", "Salty").setPrice(10f).build();
		System.out.println(parleBiscuitClass);
	}
}
