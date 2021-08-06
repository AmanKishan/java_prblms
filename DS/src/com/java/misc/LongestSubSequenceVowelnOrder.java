package com.java.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubSequenceVowelnOrder {

	private static final List<String> VOWEL_ARR = Arrays.asList("a","e","i","o","u");
	
	public static void main(String[] args) {

		String[] arr = { "i","a","e","a","i","e","j","k","i"}; 
		String[] arr1 = {"a","a","e","j","k","i","o","o","u"};
		
		
		String[] arr2 = { "i","a","e","e","i","e","j","k","i"};
		
		String[] arr3 = { "k","i","a","i","e","a","u","a","i"}; 
		System.out.println(longestSubSequenceVowelnOrder(arr3));
	}
	
	
	static int longestSubSequenceVowelnOrder(String[] arr) {
		
		List<String> longestSubSeqList = new ArrayList<>();
		
		int length = arr.length;
		String chr = "";
		int longestSubSeqCnt = 0;
		int maintain = 0;
		for(int i =0 ;i < length ;i ++) {
			chr = arr[i];
			if(longestSubSeqCnt == 0 && !arr[i].equals("a")) {
				System.out.println("---");
				continue;
			}
			
			System.out.println(chr);
			System.out.println("longestSubSeqCnt  " + longestSubSeqCnt);
			System.out.println("maintain  " + maintain);
			if(longestSubSeqList.contains(chr)) {
				if(VOWEL_ARR.get(longestSubSeqCnt-1).equals(chr)) {
					maintain++;
				}else {
					longestSubSeqList.clear();
					longestSubSeqList.add(chr);
					longestSubSeqCnt = longestSubSeqList.size();
				}
				
				
			}else if(VOWEL_ARR.contains(chr) && VOWEL_ARR.get(longestSubSeqCnt).equals(chr)){
				longestSubSeqList.add(chr);
				longestSubSeqCnt = longestSubSeqList.size();
				maintain++;
			}else if(VOWEL_ARR.contains(chr)) {
				longestSubSeqList.clear();
				longestSubSeqCnt = longestSubSeqList.size();
				
			}
			
			maintain = Math.max(maintain, longestSubSeqCnt);
			
		}
		return maintain;

	}
} 
