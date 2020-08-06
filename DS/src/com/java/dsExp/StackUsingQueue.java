package com.java.dsExp;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {


	static Queue<String> queueMain = new LinkedList<>();
	static Queue<String> queueTemp = new LinkedList<>();
	static int size;
	public StackUsingQueue() {
		size =0;
	}
	
	public void push(String element) {
		size++;
		queueTemp.add(element);
		while(!queueMain.isEmpty()) {
			queueTemp.add(queueMain.poll());
		}
		
		Queue<String> q = queueMain;
		queueMain = queueTemp;
		queueTemp = q;
	}
	
	public void pop(String element) {
	
		if(queueMain.isEmpty()) return; 
		
		queueMain.remove();
		size--;
	}
	
	 static String top()  
	    {  
	        if (queueMain.isEmpty())  
	            return "";  
	        return queueMain.peek();  
	    } 
	
	public static void main(String[] args) {
		
		StackUsingQueue stk = new StackUsingQueue();
		stk.push("aman");
		stk.push("akash");
		stk.push("manu");
		System.out.println(stk.top());
		
		
	}
}
