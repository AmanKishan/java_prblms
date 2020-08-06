package com.java.DequeProgrammingQuestions;
   import java.util.*;
    public class UniqueInContigiousSubArray2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Long startTime =System.currentTimeMillis();
            Deque<Integer> deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            HashSet<Integer> set = new HashSet<>();
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.add(num);
                
                
                set.add(num);
                
                if(deque.size() == m) {
                	if(set.size() > max ) max = set.size();
                	
                	Integer first = deque.removeFirst();
                	if(!deque.contains(first)) set.remove(first);
                }
            }
            in.close();
            Long endTime =System.currentTimeMillis();
            System.out.println(max);
            System.out.println("Total Time taken " + (endTime-startTime)/1000);
        }
    }