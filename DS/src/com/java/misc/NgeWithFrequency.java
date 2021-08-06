package com.java.misc;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @author amanrastogi
 *
 * @see {@link <a href="https://www.geeksforgeeks.org/next-greater-frequency-element/">Next Greater Frequency Element
</a> }
 */
public class NgeWithFrequency {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 3, 4, 2, 1 };

		ngeWithFrequency(arr, arr.length);
	}

	public static void ngeWithFrequency(int arr[], int n) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (int i = 0; i < n; i++) {

			arr[i] = map.get(arr[i]);

		}

		ngeWithFreDiff(arr, arr.length, map);
	}

	public static void ngeWithFreDiff(int arr[], int n, HashMap<Integer, Integer> map) {

		Stack<Integer> stack = new Stack<Integer>();

		int arrNew[] = new int[arr.length + 1];

		
		for (int i = n -1; i >= 0; i--) {

			int arrElement = arr[i];

			while (!stack.isEmpty() && arrElement >= stack.peek()) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				arrNew[i] = -1;
			} else {
				arrNew[i] = map.get(stack.peek());
			}

			stack.add(arrElement);
		}

		for (int i = 0; i < n; i++) {

			System.out.print(arrNew[i] + " ");
		}

	}
}
