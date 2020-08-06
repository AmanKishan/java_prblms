package com.lambdaException.java;

import java.util.function.BiConsumer;

public class LambdaException {

	public static void main(String[] args) {
		
		int [] intArr = {14,15,13,5};
		int key = 0;
		
		//this is not the elegant way to code in case of lambda since 
		//it increse the line of code
		/*Process(intArr,key,(v,k)->{
			try{
				System.out.println(v/k);	
			}catch(Exception e) {
				
				System.out.println("Exception occur : " + e);
			}
			
			});*/
		//Process(intArr,key,(v,k)->System.out.println(v/k));//without handling the exception

		//handling the exception
		Process(intArr,key,wrapperLambda((v,k)->System.out.println(v/k)));
		
	}

	//separate exception from actual code
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biCon) {
		return (v,k) ->{
			try {
				biCon.accept(v, k);	
			}catch(ArithmeticException e) {
				System.out.println("Exception occure :: " + e);
			}
			
		};
	}

	private static void Process(int[] intArr ,int  key,BiConsumer<Integer, Integer> biConsumer) {
		
		for(int i : intArr) {
			biConsumer.accept(i, key);
		}
	}
}
