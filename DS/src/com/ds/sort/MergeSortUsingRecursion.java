package com.ds.sort;

public class MergeSortUsingRecursion {

	public static void main(String[] args) {

		MergeSortUsingRecursion mergeSortUsingRecursion = new MergeSortUsingRecursion();
		int arr[] = {3,4,2,7,5,8,10,6};
		mergeSortUsingRecursion.sort(arr, 0, arr.length-1);
		
		for(int i =0 ; i < arr.length ;i ++) {
			System.out.print(arr[i] + " ");
			
		}
	}
	

	public void sort(int[] arr, int L, int H) {

		if (L < H) {

			
			//int M = L + (H - L)/2;// or 
			int M = (L+H)/2;

			sort(arr, L, M);

			sort(arr, M + 1, H);

			//System.out.println("L: "  + L + " M: "+  M + " H: " + H );
			merge(arr, L, M, H);
		}

	}

	public void merge(int arr[], int L, int M, int H) {
		
		// First make two array Left and Right array
		int leftSize = M - L + 1;
		int rightSize = H - M;

		int leftArr[] = new int[leftSize];
		int rightArr[] = new int[rightSize];
		
		// Fill both and right array
		for (int i = 0; i < leftSize; i++) {
			leftArr[i] = arr[L+i];
		}

		for (int j = 0; j < rightSize; j++) {
			rightArr[j] = arr[M+1+j];
		}
		
		// for compare the set
		
		int i = 0 , j = 0;
		
		int k = L; // This is because for every recursion call we need to skip sorted subarray
				
		while(i < leftSize && j < rightSize) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			}else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i < leftSize) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		
		while(j < rightSize) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

}
