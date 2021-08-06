package com.java.hashsetProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class FindUniquePairCount {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
			set.add(pair_left[i] + " - " + pair_right[i]);
			System.out.println(set.size());

		}
	}
}

/**Sample Input
5
john tom
john mary
john tom
mary anna
mary anna

*/

/**
 1
2
2
3
3
 */
 


