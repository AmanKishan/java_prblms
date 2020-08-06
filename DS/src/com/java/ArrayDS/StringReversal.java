package com.java.ArrayDS;

public class StringReversal {

	public static String reversal(String str) {
		String newStr = "";
		char[] try1 = str.toCharArray();
		for (int i = try1.length - 1; i >= 0; i--) {
			newStr = newStr + (try1[i] + "");
		}

		return newStr;
	}

	public static String reversalUsinByteArr(String str) {
		
		byte [] strByteArr = str.getBytes();
		
		byte [] result = new byte[str.length()];
		
		for(int i =0; i < strByteArr.length ; i++) {
			result[i] = strByteArr[strByteArr.length  - i -1];
				}
		
		return new String(result);
	}

	public static String reversalusingSwap(String str ) {
		char[] charArr = str.toCharArray();
		int left =0;
		int right = charArr.length - 1;
		
		for(left = 0; left < right ; left++, right--) {
			char temp = charArr[right];
			charArr[right] =charArr[left]; 
			charArr[left] = temp;
		}
		
		return  new String(charArr);
		
		
	}
	public static void main(String[] args) {

		System.out.println(StringReversal.reversal("Aman"));
		System.out.println(StringReversal.reversalUsinByteArr("Aman"));
		System.out.println(StringReversal.reversalusingSwap("Aman"));

	}

}
