package com.java.streamExp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

	
	public static void main(String[] args) {
		
		
		 List<String> lst = Arrays.asList("STACK","OOOVER");
		    List<String> lst1 = lst.stream().map(w->w.split("")).flatMap(Arrays :: stream)
		    		.distinct().collect(Collectors.toList());
		    
		    System.out.println(lst1);
		    
		    
		    String str[] = {"staack" , "ooovverfllow"};
 		    Stream<String> StreamOfwords  =  Arrays.stream(str);
 		   List<String> lst3 = StreamOfwords.map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
 		  System.out.println(lst3);
 		  
 		  
 		  List<Integer> intlist1 = Arrays.asList(1,2,3,4);
 		 List<Integer> intlist2 = Arrays.asList(2,3,5,6);
 		List<Integer> intlist3= null;
 	
 		
 		intlist1.stream().forEach(i -> 
		{
			intlist2.stream().filter(j -> j == i).map( j -> (j+1)).collect(Collectors.toList());
 		});
 
 		for(Integer i :intlist1 ) {
 			Integer opInt = intlist2.stream().filter(j -> j == i ).findFirst().orElse(8);//same work as break
 			System.out.println(opInt);
 		}
 		
 		
 		intlist3 = intlist2.stream().filter(j ->intlist1.contains(j)).
 				collect(Collectors.toList());
 		
 		System.out.println(intlist3);
 		 
		    
	}
}
