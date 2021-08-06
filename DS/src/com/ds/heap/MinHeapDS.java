package com.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapDS {

	private int size;

	private int heapArr[];

	private void ensureCapacity() {

		if (this.heapArr.length * .75 < this.size) {
			this.heapArr = resize();
		}
	}

	private int[] resize() {
		int[] newHeapArr = new int[this.heapArr.length * 2];
		for (int i = 0; i < this.heapArr.length; i++) {
			newHeapArr[i] = this.heapArr[i];
		}
		return newHeapArr;
	}

	public MinHeapDS(int capacity) {

		heapArr = new int[capacity + 1];
		this.size = 0;
	}

	// get parent index of any child is (i-1)/2 take floor 
	private int getParentIdx(int childIdx) {

		return (childIdx - 1) / 2;
	}
	

	private int leftChildIndex(int parentIdx) {

		return (2 * parentIdx) + 1;
	}

	private int rightChildIndex(int parentIdx) {

		return (2 * parentIdx) + 2;
	}

	private int getParent(int idx) {

		return this.heapArr[getParentIdx(idx)];
	}

	private int leftChild(int idx) {

		return this.heapArr[leftChildIndex(idx)];
	}

	private int rightChild(int idx) {

		return this.heapArr[rightChildIndex(idx)];
	}

	private boolean hasParent(int idx) {

		return getParentIdx(idx) >=0;
	}

	private boolean hasLeftChild(int idx) {

		return leftChildIndex(idx) < this.size;
	}

	private boolean hasRightChild(int idx) {

		return rightChildIndex(idx) < this.size;
	}

	private void swap(int cidx , int pidx) {
		
		int temp = this.heapArr[pidx];
		this.heapArr[pidx]= this.heapArr[cidx];
		this.heapArr[cidx]=  temp;
		
	}
	public static void main(String[] args) {

		MinHeapDS heapDS = new MinHeapDS(5);
		heapDS.addToHeap(30);
		heapDS.addToHeap(5);
		heapDS.addToHeap(10);
		heapDS.addToHeap(7);
		heapDS.addToHeap(19);
		heapDS.addToHeap(27);
		
		for(int i =0;i <heapDS.size;i++) {
			
			System.out.print(heapDS.heapArr[i] + " ");
		}
		
		
		heapDS.poll();
		
		System.out.println("");
		
		System.out.println("-----After Polling root-----");
		
		for(int i =0;i <heapDS.size;i++) {
			
			System.out.print(heapDS.heapArr[i] + " ");
		}

	}

	private void addToHeap(int itm) {

		ensureCapacity();
		heapArr[this.size] = itm;
		this.size++;
		heapifyUp();
	}

	// Polling heap operation
	private int poll() {

		int itm = this.heapArr[0] ;
		this.heapArr[0] = this.heapArr[size -1];
		this.size--;
		heapifyDown();
		return itm;
		
	}
	
	private void heapifyUp() {
		
		int idx = this.size -1;
		while(hasParent(idx) && getParent(idx) > this.heapArr[idx]) {
			swap(idx, getParentIdx(idx));
			idx = getParentIdx(idx);
		}

	}


	private void heapifyDown() {

		int idx = 0;
		while(hasLeftChild(idx)) {// Check idx have left child
			int smalleChildIdx = leftChildIndex(idx); 
			if(hasRightChild(idx) && rightChild(idx) < leftChild(idx)) { // check weather left or right which one is smaller
				smalleChildIdx = rightChildIndex(idx);
			}
			
			if(this.heapArr[idx] < this.heapArr[smalleChildIdx]) { // if smaller child is grater than root it ok else swap and make idx as smaller child and do the process again
				break;
			}else {
				swap(idx, smalleChildIdx);
			}
			
			idx = smalleChildIdx;
			
		}
	}

}
