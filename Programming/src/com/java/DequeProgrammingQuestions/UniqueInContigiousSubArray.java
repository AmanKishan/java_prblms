package com.java.DequeProgrammingQuestions;

import java.util.*;

public class UniqueInContigiousSubArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Long startTime = System.currentTimeMillis();
		Deque<Integer> deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.add(num);
			
			if (deque.size() == m) {
				int count = (int) deque.parallelStream().distinct().count();
				if (count > max)
					max = count;
				deque.removeFirst();
			}
		}
		in.close();
		Long endTime = System.currentTimeMillis();
		System.out.println(max);
		System.out.println("Total Time taken " + (endTime - startTime) / 1000);
	}
}