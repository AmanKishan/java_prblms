package com.java.String;

/**
 * 
 * @author arastogi
 *
 * When the intern() method is executed then it checks 
 * whether the String equals to this String Object is in the pool or not.
 * If it is available, then the string from the pool is returned. 
 * Otherwise, this String object is added to the pool and
 * a reference to this String object is returned.
 * 
 */
public class StringTest {

	public static void main(String[] args) {

		String s= "Aman";
		String s1= "Aman";
		 s = s + s1;
		System.out.println(s1); // AMAN
		System.out.println(s == s1); // FALSE
		String s3 = new String(s1); 
		System.out.println(s == s3); //FALSE
		System.out.println(s1 == s3); //FALSE
		
		
		String str = new String("Sachin");
		String str1  = "Sachin";
		String str2=str.intern();// IMPORTANT TOPIC//TODO
		System.out.println(str1 == str2);
		System.out.println(str2);
		
		
	}

}
