package com.java.misc;

public class TopThreeLargest {

	public static void main(String[] args) {
		
		int arr[] = {4,1,8,3,10,5,11,17};
		
		topThreeLargest(arr, arr.length);
		
	}
	
	
	public static void topThreeLargest(int arr[], int n) {
		
		int firstLargest= Integer.MIN_VALUE;
		int secondLargest= Integer.MIN_VALUE;
		int thirdLargest = Integer.MIN_VALUE;
		
		for(int i = 0; i < n ; i++) {
			
			if(arr[i] > firstLargest) {
				thirdLargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = arr[i];
			}
			
			
			if(firstLargest > arr[i] && secondLargest < firstLargest) {
				secondLargest = arr[i];
				
			}
			
			if(secondLargest > arr[i] && thirdLargest < secondLargest ) {
				thirdLargest = arr[i];
			}
			
		}
		
		System.out.println("firstLargest: " + firstLargest + " secondLargest: " + secondLargest + " thirdLargest " + thirdLargest );
		
	}
	

}



