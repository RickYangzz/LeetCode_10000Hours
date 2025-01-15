package BM45_滑动窗口的最大值.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @param size int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if(num.length == 0 || size == 0 || size > num.length) return res;

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            while(!dq.isEmpty() && num[dq.getLast()] <= num[i]){
                dq.pollLast();
            }
            
            dq.offer(i);

            while(!dq.isEmpty() && dq.peek() < i + 1 - size){
                dq.pollFirst();
            }

            if(!dq.isEmpty() && i + 1 - size >= 0) {
                res.add(num[dq.peek()]);
            }
        }

        return res;
    }
}