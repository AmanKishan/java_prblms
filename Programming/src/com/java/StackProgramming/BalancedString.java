package com.java.StackProgramming;

import java.util.Scanner;
import java.util.Stack;

public class BalancedString {

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		
		
		while (sc.hasNext()) {
			
			System.out.println(balancedChecked(sc));
		}
		
		
	}

	private static boolean balancedChecked(Scanner sc) {
		

		String input=sc.next();
		Stack<Character> stack = new Stack<>();
		for(Character chr : input.toCharArray() ) {
			switch (chr) {
			
			case '{':stack.push(chr);break;
			
			case '(':stack.push(chr);break;
			
			case '[':stack.push(chr);break;
			
			case '}':
			
				if(stack.isEmpty() || stack.pop() != '{')
					return false;
				break;
			
			case ')':
				if(stack.isEmpty() || stack.pop() != '(')
					return false;
				break;
			case ']':
				if(stack.isEmpty() || stack.pop() != '[')
					return false;
				break;
			
				
				
			}
		}
		return stack.isEmpty();
	
		
	}

}
