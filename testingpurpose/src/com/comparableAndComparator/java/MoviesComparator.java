package com.comparableAndComparator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class MoviesComparator {

	double rating;
	String name;
	int year;

	public MoviesComparator( String name ,double rating , int year) {
		this.rating = rating;
		this.name = name ;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movies [rating=" + rating + ", name=" + name + ", year=" + year + "]";
	}

	
	public static void main(String[] args) {

		
		
		
		ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        list.add(new Movie("A Return of the Jedi", 8.4, 1983));
 
        
        
        
        
        Collections.sort(list,new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.year - o2.year;//asc order sort
			}
		});
        
        list.forEach(System.out::println);
        System.out.println("******************");
        Collections.sort(list,new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
			 return o1.name.compareTo(o2.name);
			}
		});
        list.forEach(System.out::println);
        System.out.println("******************");
        Collections.sort(list,Comparator.comparing((Movie m ) -> m.year).thenComparing(m -> m.name));
        list.forEach(System.out::println);
        
        System.out.println("******************");
        list.sort(Comparator.comparing((Movie m ) -> m.name).thenComparing(m -> m.year));
        
        list.forEach(System.out::println);
	}
}
