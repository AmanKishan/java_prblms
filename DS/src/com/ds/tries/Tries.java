package com.ds.tries;

import java.util.ArrayList;

/*
 * 
 * 
 * Charters ASCII values
 * 
 * a = 97 
 * A = 65
 * 
 * No need to store charter since charters is represented by array index
 * 
 * 0 means a and 1 means b
 */
public class Tries {

	private Node parentNode = new Node(-1); // parent count as -1

	static class Node {

		private Node[] childs;
		private int cnt;
		private boolean endOfPath;
	
		public Node() {
			this.endOfPath = false;
			this.childs = new Node[26];

		}

		public Node(int cnt) {
			this();
			this.cnt = cnt;
		}

	}

	public void insertNode(String word) {

		Node node = this.parentNode;

		int n = word.length();

		for (int i = 0; i < n; i++) {

			int idx = word.charAt(i) - 'a';// get charter index if b is come then 98-97 = 1, thus b index is 1;

			if (node.childs[idx] == null) {

				node.childs[idx] = new Node();

			}

			node = node.childs[idx];
			
			if(node.endOfPath)  {
				node.endOfPath =false;
			}
		}

		node.cnt = node.cnt++;// whatever the node count have increase it
		
		node.endOfPath = checkIsEndOfPath(node);	

	}

	private boolean checkIsEndOfPath(Node node) {
		boolean flag = true;
		for(int i =0 ;i < 26 ; i++) {
			if(node.childs[i] != null) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private Node search(String word) {

		Node node = this.parentNode;

		int n = word.length();

		for (int i = 0; i < n; i++) {

			int idx = word.charAt(i) - 'a';

			if (node.childs[idx] == null) {

				break;
			}

			node = node.childs[idx];
		}

		return node;
	}

	
	// get all paths
	public String[] getLargestUnqiueWords(String wordsArr[]) {

		int n = wordsArr.length;
		String[] uniqueWords = new String[n];
		
		for(int i =0 ;i < n ;i ++ ) {
		
			Node node = search(wordsArr[i]);
			
			if(node.endOfPath) {
				uniqueWords[i] = wordsArr[i];
			}
		}
		
		return uniqueWords;
		
	}
	

	public static void main(String[] args) {

		Tries tries = new Tries();
		
		String[] words = { "geeks", "geek", "ab", "geek" ,"code", "karega"};
		for(int i =0 ;i < words.length ; i++) {
			tries.insertNode(words[i]);
		}

		
		String[] uniqueWords =  tries.getLargestUnqiueWords(words);
		for(int i= 0 ;i < uniqueWords.length ; i++) {
			if(uniqueWords[i] != null) {
				System.out.println(" " + uniqueWords[i]);
			}
		}
	}

}
