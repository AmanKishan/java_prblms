package com.java.misc;

import java.util.Stack;

/**
 * 
 * @see {@link <a href=
 *      "https://www.geeksforgeeks.org/next-greater-element/">Find NGE without
 *      order</a> }
 * 
 */

public class NextGreaterInOrderOfArray {

	public static void main(String[] args) {

		int arr[] = { 13, 15, 6, 12 };
		//nextGreatestBruteForce(arr, arr.length);
		//nextGreatest(arr, arr.length);
		nextGreaterInOrder(arr, arr.length);

	}

	public static void nextGreatestBruteForce(int arr[], int n) {

		for (int i = 0; i < n; i++) {

			int nge = -1;

			for (int j = i + 1; j < n; j++) {

				if (arr[i] < arr[j]) {
					nge = arr[j];
					break;
				}

			}
			System.out.println(arr[i] + " : " + nge);
		}
	}

	// if smaller is coming keep in the stack , if greater is coming pop from the
	// stack the check again in while loop

	// last element left in stack have no nge

	public static void nextGreatest(int arr[], int n) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {

			int arrElement = arr[i];

			if (!stack.isEmpty()) { // if stack is not empty

				int stackElement = stack.pop();
				while (arrElement > stackElement) {

					System.out.println(stackElement + " ===> " + arrElement);

					if (stack.isEmpty())
						break;

					stackElement = stack.pop();

				}

				if (arrElement < stackElement) {

					stack.add(stackElement);
				}

			}

			stack.add(arrElement);

		}

		while (!stack.isEmpty()) {

			System.out.println(stack.pop() + " ===> -1");
		}

	}
	
	
	// This approch is used to print the order of the elemets in this aproch we start from right if greater is present we keep it in the stack else remove it 

	public static void nextGreaterInOrder(int arr[], int n) {

		Stack<Integer> stack = new Stack<Integer>();

		int arrNew[] = new int[arr.length + 1];
		
		
		for(int i = n-1; i >=0 ;i--) {
			
			int arrElement = arr[i];
			
			while(!stack.isEmpty() && stack.peek() <= arrElement) {
				stack.pop();
				
			}
			
			if(stack.isEmpty()) {
				arrNew[i] = -1;
			}else {
				arrNew[i] = stack.peek();
			}
			
			stack.add(arrElement);
			
		}
		
		
		for(int i = 0; i< n;i++) {
			System.out.println(arr[i] + " ---------- " + arrNew[i]);
		}
	}
}
