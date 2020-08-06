package com.java.creationOfDs;

import java.util.Arrays;

/**
 * custom stack implementation using object array
 */
public class MyStack<E> {

	private static final long serialVersionUID = 7735328430993296033L;
	
	private Object elements[];
	private int size = 0;
	private static final int DEAFULT_CAPACITY = 10;

	public MyStack() {
		elements = new Object[DEAFULT_CAPACITY];
	}

	public void push(E e) {
		
		if(size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}
	private void ensureCapacity() {

		int newSize = elements.length*2;
		elements = Arrays.copyOf(elements, newSize);
	}

	public E pop() {
		
		if(elements.length > 0) {
				
			E e = (E) elements[--size];
			elements[size] = null;
			return e;
		}
		return null;
		
	}
	
	
	   @Override
	    public String toString()
	    {
	         StringBuilder sb = new StringBuilder();
	         sb.append('[');
	         for(int i = 0; i < size ;i++) {
	             sb.append(elements[i].toString());
	             if(i < size-1){
	                 sb.append(",");
	             }
	         }
	         sb.append(']');
	         return sb.toString();
	    }
	public static void main(String[] args) {

		
		MyStack<Integer> stack = new MyStack<>();
	      
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	        stack.push(40);
	         
	        System.out.println(stack);
	         
	        System.out.println( stack.pop() );
	        System.out.println( stack.pop() );
	        System.out.println( stack.pop() );
	         
	        System.out.println( stack );
	}

}
