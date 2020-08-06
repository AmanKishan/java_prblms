package com.creational.deisgn.pattern.factory;

public class BiscuitFactory {

	
	public AbstractParleBisCuit computeBiscut(String biscuitName , String size , String type ) {
		
		
		if(biscuitName.equalsIgnoreCase("monoco")) {
			return new MonacoBiscuit(size, type);
		}else if(biscuitName.equalsIgnoreCase("parleg")) {
			return new ParleG(size, type);
		}else if(biscuitName.equalsIgnoreCase("CrackJack")) {
			return new KrackJack(size, type);
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		
		BiscuitFactory factory = new BiscuitFactory();
		AbstractParleBisCuit parlebiscuit = factory.computeBiscut("monoco", "20Gm", "salty");
		System.out.println("Biscuit Class : " + parlebiscuit.getClass().getSimpleName() + ",  Details : "+  parlebiscuit.toString());
		

	}

}
