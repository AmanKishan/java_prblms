package com.java.interfaceq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DiamondClassImpAandB implements InterfaceA, InterfaceB {

	@Override
	public void foo() {
	
		System.out.println("DiamondClassImpAandB");
	}

	//You have to give specific implementation of default method if both class have same methods 
	
	@Override
	public void fooDefault() {

		InterfaceA.super.fooDefault();    
		InterfaceB.super.fooDefault();
		
		
		Map<String, Map<Integer, List<Integer>>> map  =  new HashMap<>();
		List<Integer> list = map.values().stream().flatMap(map -> map.values().stream()).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		DiamondClassImpAandB d = new DiamondClassImpAandB();
		//d.foo();
		d.fooDefault();
	}

}
