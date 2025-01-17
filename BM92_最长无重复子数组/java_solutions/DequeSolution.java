package BM92_最长无重复子数组.java_solutions;

import java.util.LinkedList;

public class DequeSolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        int maxLength = 0;

        LinkedList<Integer> dq = new LinkedList<Integer>();

        for (Integer value : arr) {
            while(dq.contains(value)){
                dq.poll();
            }

            dq.add(value);

            maxLength = Math.max(maxLength, dq.size());
        }

        return maxLength;
    }
}