package com.java.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasicOperation {

	
	
	public Stream<String> createStream() {
		Stream<String> strm = Stream.empty();
		return strm;
	}
	
	public void printStream(Stream<String> strm) {
			strm.forEach(System.out::println);
	}
	
	public Stream<String> convertListToStream(List<String> list) {
		return list.stream();
	}
	
	
	public static void main(String[] args) {
	

		StreamBasicOperation opr = new StreamBasicOperation();
		Stream<String> strm = opr.createStream();
		//opr.printStream(strm);
		
		String strArr[] = {"AMAN","AKASH","MANU","VISHAL","VIKAS","TANU","YASH"};
		
		List<String> list = Arrays.asList(strArr);
		
		strm = opr.convertListToStream(list);
		
		//opr.printStream(strm);
		
		//words more than 5 characters
		//strm.filter(itm-> itm.length() > 4).collect(Collectors.toList()).forEach(System.out::println);
		
		//words starts with A
		//strm.filter(itm-> itm.startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);
		
		//words start with A appends Rastogi in it
		//strm.filter(itm-> itm.startsWith("A")).map(itm-> itm + " Rastogi").collect(Collectors.toList()).forEach(System.out::println);
		
		//join all words as one exp : AMANAKASHMANU....
		//@Link https://stackoverflow.com/questions/26684562/whats-the-difference-between-map-and-flatmap-methods-in-java-8
		//strm.map(itm-> itm.split("")).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(System.out::print);
		/*replacement of method references*/
		//strm.map(itm-> itm.split("")).flatMap(i -> Stream.of(i)).collect(Collectors.toList()).forEach(System.out::print);
		
		//skip starting two elements
		//strm.skip(2).collect(Collectors.toList()).forEach(System.out::println);
		
		//System.out.println("Find first " + strm.findFirst().get());
		//System.out.println("Find any " + strm.findAny());
		
		//System.out.println("Check boolean " + strm.anyMatch(itm -> itm.equalsIgnoreCase("aman")));
		//System.out.println("Check boolean " + strm.allMatch(itm -> itm.equalsIgnoreCase("aman")));
		
		//System.out.println("Check boolean " + strm.noneMatch(itm -> itm.equalsIgnoreCase("aman")));
		
		//sort  in natural order
		//strm.sorted().collect(Collectors.toList()).forEach(System.out::println);
		//System.out.println("Total Count " + strm.count());
		
		
	}

}
