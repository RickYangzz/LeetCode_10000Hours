package BM53_缺失的第一个正整数.java_solutions;

public class Solution {
    /**
     * 
     * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
     * 
     * 
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared(int[] nums) {
        int N = nums.length;

        // 第一次遍历 清除掉所有的非正数
        for (int i = 0; i < N; i++) {
            int value = nums[i];
            if (value <= 0)
                nums[i] = N + 1;
        }

        // 第二次遍历 给所有下标打上标记
        for (int i = 0; i < N; i++) {
            int value = Math.abs(nums[i]);

            if (value <= N) {
                nums[value - 1] = -1 * Math.abs(nums[value - 1]);
            }
        }

        // 第三次遍历 找到第一个非负数的下标
        for (int i = 0; i < N; i++) {
            int value = nums[i];

            if(value > 0) return i+1;
        }

        return N+1;
    }
}