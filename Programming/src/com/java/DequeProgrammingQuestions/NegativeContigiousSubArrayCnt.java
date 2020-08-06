package com.java.DequeProgrammingQuestions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class NegativeContigiousSubArrayCnt {

	/**
	 * 
	 *  Input 
	 * 5
	   1 -2 4 -5 1
	   Output 
	   9
	   Explanation :
	   
	https://www.hackerrank.com/challenges/java-negative-subarray/problem
	   
	 */
	
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = n;
        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        
        while (m > 0) {
            
            for (int i = 0; i < a.length; i++) {
                int num = a[i];

                deque.add(num);

                if (deque.size() == m) {
                    int sum = deque.stream().mapToInt(Integer::intValue).sum();
                    
                    deque.removeFirst();
                    if (sum < 0) {
                        cnt++;
                    }

                }
            }
            m = m - 1;
            deque.clear();
        }

        in.close();
        System.out.println(cnt);
    
    }
}

