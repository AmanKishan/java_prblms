package com.creational.deisgn.pattern.singelton.reflection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	String t1;
	String t2;
	
	

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		
		return true;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [t1=");
		builder.append(t1);
		builder.append(", t2=");
		builder.append(t2);
		builder.append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		Map<Test,String> map = new HashMap<>();
		map.put(t1, "abc");
		map.put(t2, "xyz");
		
		Set<Test> set = new HashSet<>();
		set.add(t1);
		set.add(t2);
		System.out.println(map);
		System.out.println(map.get(t1));
		System.out.println(map.get(t2));
		
		System.out.println(set);
		
	}
	
	
}
