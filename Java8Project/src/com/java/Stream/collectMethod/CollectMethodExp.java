package com.java.Stream.collectMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectMethodExp {

	public static void main(String[] args) {

		String strArr[] = {"AMAN","AKASH","MANU","VISHAL","VIKAS","TANU","YASH"};
		List<String> list = Arrays.asList(strArr);
		
		//Collect function 
		//supplier accumulator and combiner (supplier,accumulator,combiner)
		/*String str = list.stream().parallel().collect(StringBuilder::new,
		  (res,elem) -> res.append("").append(elem),
			(res1,res2) -> res1.append(", ").append(res2.toString())).toString();
			System.out.println(str);*/
			
			
		//separetly create the Collector
		
		Supplier<StringBuilder> supplier = StringBuilder::new;
		BiConsumer<StringBuilder, String> accumulator = (res,elem) -> res.append("").append(elem);
		BiConsumer<StringBuilder, StringBuilder> combiner = (res1,res2) -> res1.append(", ").append(res2.toString());
		
		//combiner only works with parallel streams
		String str = list.stream().parallel().collect(supplier,accumulator,combiner).toString();
		System.out.println(str);
		
		
		//reuse the stream using supplier
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("a","b","c");	
		List<String> listA = streamSupplier.get().collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
		System.out.println(listA);
		
		List<String> listB = streamSupplier.get().collect(Collectors.toList());
		System.out.println(listB);
		
		
		String strJoin = streamSupplier.get().collect(Collectors.joining(", "));
		System.out.println(strJoin);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(1,"aman"));
		studentList.add(new Student(2,"akash"));
		studentList.add(new Student(3,"vishal"));
		studentList.add(new Student(4,"manu"));
		studentList.add(new Student(5,"tanu"));
		studentList.add(new Student(6,"vikas"));
		studentList.add(new Student(7,"yash"));
		studentList.add(new Student(8,"ujjwal"));
		studentList.add(new Student(9,"kanish"));
		
		//convert into map keyMapper and ValueMapper
		
		Map<Integer,String> mapOfStudents = 
		studentList.stream().collect(Collectors.toMap(Student::getId, Student::getName));
		System.out.println(mapOfStudents);
		
		
		
	}
}
