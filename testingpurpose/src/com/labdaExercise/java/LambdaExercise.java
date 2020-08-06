package com.labdaExercise.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExercise {

	public static void main(String[] args) {


		List<Person> personList = Arrays.asList(
				new Person("Lakshit", 28),
				new Person("Aman",26),
				new Person("Mausam",27)
				);
		
		/*using java 7*/
/*		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {

				return p1.getName().compareTo(p2.getName());
			}
			
		});
		*/
		personList.forEach(p->System.out.println(p));
		//Collections.sort(personList, (p1,p2)->p1.getName().compareTo(p2.getName()));
		System.out.println("------------^^^^^^^^^^^^^^^^^^^^^^");
		Collections.sort(personList, Comparator.comparing(Person::getName));//used  method references
		personList.forEach(p->System.out.println(p));
		
		/*using java 7*/
/*		personList.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});*/
		
		personList.sort((p1,p2)->p1.getName().compareTo(p2.getName()));
		personList.sort(Comparator.comparing(Person::getName));//by using method reference
		
		/*java 7*/
/*		personList.stream().filter(new Predicate<Person>() {

			@Override
			public boolean test(Person p) {
				
				return p.getName().startsWith("A");
			}
		});*/
		
		System.out.println("---------------");
		personList.stream().filter(p->p.getName().startsWith("A")).forEach(p->System.out.println(p));
		
		System.out.println(":::::");
		performCondition(personList,p->true,p->System.out.println(p));
		System.out.println("$$$$$");
		performCondition(personList,p->p.getName().startsWith("A"),p->System.out.println(p));
		
		performCondition(personList,p->p.getName().startsWith("A"),System.out::println);//same as above just using method reference
	}

	private static void performCondition(List<Person> personList , Predicate<Person> p , Consumer<Person> consumer) {
		//personList.stream().filter(p).forEach(t->consumer.accept(t));
		/*Using method references*/
		personList.stream().filter(p).forEach(consumer::accept);
	}
}
