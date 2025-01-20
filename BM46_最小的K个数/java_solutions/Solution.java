package BM46_最小的K个数.java_solutions;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param input int整型一维数组 
     * @param k int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        if(input == null || input.length == 0 || k == 0) return new ArrayList<Integer>();

        // Edge case: if k is greater than or equal to the array length
        if (k >= input.length) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int num : input) {
                result.add(num);
            }
            Collections.sort(result); // Sort the entire array
            return result;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < k; i++) {
            pq.offer(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if(input[i] < pq.peek()){
                pq.poll();
                pq.offer(input[i]);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}