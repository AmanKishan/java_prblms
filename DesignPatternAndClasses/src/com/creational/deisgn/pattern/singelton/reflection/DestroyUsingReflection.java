package com.creational.deisgn.pattern.singelton.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.creational.deisgn.pattern.singalton.EagerSingelton;

public class DestroyUsingReflection {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		EagerSingelton eagerObjOne = EagerSingelton.getSingeltonObject();
		EagerSingelton eagerObjTwo =null;
		Constructor[] constructors = EagerSingelton.class.getDeclaredConstructors();
		System.out.println(constructors.length);
		for(Constructor cnstr : constructors) {
			cnstr.setAccessible(true);
			eagerObjTwo = (EagerSingelton) cnstr.newInstance();
			
		}
		
		System.out.println(eagerObjOne.hashCode());
		System.out.println(eagerObjTwo.hashCode());
	}

}
