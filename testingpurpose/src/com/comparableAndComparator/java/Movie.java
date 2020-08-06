package com.comparableAndComparator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/** This is a movie class*/
public class Movie implements Comparable<Movie> {

	
	double rating;
	String name;
	int year;

	
	public Movie( String name ,double rating , int year) {
		this.rating = rating;
		this.name = name ;
		this.year = year;
	}
	
	// if year is same then compare on the basis of name
	@Override
	public int compareTo(Movie o) {
		int i =  this.year - o.year;//asc order sort //
		if(i != 0) return i;
		
		i = this.name.compareTo(o.name);//asc order sort
		if(i != 0) return i;
		
		return i;
	}

	public static void main(String[] args) {
		
		ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        list.add(new Movie("WordCup", 9, 1983));
 
        Collections.sort(list);
        
        list.forEach(System.out::println);
	}
	@Override
	public String toString() {
		return "Movie [rating=" + rating + ", name=" + name + ", year=" + year + "]";
	}
	
	
}
