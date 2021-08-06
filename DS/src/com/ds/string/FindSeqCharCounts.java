package com.ds.string;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class FindSeqCharCounts {

	public static void main(String[] args) {

		// System.out.println(getSeqCharCounts("aaabbaaaacfff"));

		Random rd = new Random();

		int input = rd.nextInt(7311615); // 52^4 -1

		final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] allowedCharacters = allowedString.toCharArray();

		StringBuilder builder = new StringBuilder();
		
		
		Queue<Integer> queue = new ArrayDeque<>();
				
		while (input > 0) {

			builder.append(allowedCharacters[input % 52]);
			input = input / 52;
		}

	}

	public static Map<Character, Integer> getSeqCharCounts(String str) {

		char[] chars = (str + "!").toCharArray(); // add as delimiter

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int cnt = 1;

		for (int i = 0; i < chars.length - 1; i++) {

			if (chars[i] == chars[i + 1]) {
				cnt++;

			} else {
				if (map.containsKey(chars[i])) {
					if (map.get(chars[i]) < cnt) {
						map.put(chars[i], cnt);
					}
				} else {
					map.put(chars[i], cnt);
				}
				cnt = 1;
			}
		}
		return map;
	}

}
