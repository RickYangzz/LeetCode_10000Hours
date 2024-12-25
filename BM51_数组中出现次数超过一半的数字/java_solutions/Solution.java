package BM51_数组中出现次数超过一半的数字.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 给一个长度为 n 的数组，
     * 数组中有一个数字出现的次数超过数组长度的一半，
     * 请找出这个数字。
     * 
     * 例如输入一个长度9的数组[1,2,3,2,2,2,5,4,2]。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     * 
     * 数据范围：n≤50000，数组中元素的值 0≤val≤10000
     * 要求：空间复杂度：O(1)，时间复杂度 O(n)
     * 
     * @param numbers int整型一维数组 
     * @return int整型
     */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        
        Map<Integer, Integer> counter = new HashMap<>();
        
        // 遍历数组，记录每个数字出现的次数
        for (int num : numbers) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        // 遍历Map，找到出现次数最多的数字
        int result = numbers[0];
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > maxCount) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return result;
    }
}
