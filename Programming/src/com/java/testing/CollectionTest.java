package com.java.testing;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(8);
		
		// Concurrent modification exception
		for(Integer ele: list) {
			list.add(ele);
		}
	}

}
