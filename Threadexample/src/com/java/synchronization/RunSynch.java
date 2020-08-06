package com.java.synchronization;

public class RunSynch {

	public static void main(String[] args) {

		ResourceObject r = new ResourceObject();
		ThreadOne t1 = new ThreadOne(r);
		ThreadTwo t2 = new ThreadTwo(r);
		ThreadThree t3 = new ThreadThree(r);
		t1.start();
		t2.start();
		t3.start();

	}

}
