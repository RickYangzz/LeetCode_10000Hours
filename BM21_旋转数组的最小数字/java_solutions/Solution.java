package BM21_旋转数组的最小数字.java_solutions;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int middle = (i + j) / 2;

            if (nums[middle] > nums[j]) {
                i = middle + 1;
            } else if (nums[middle] == nums[j]) {
                j--;
            } else {
                j = middle;
            }
        }

        return nums[j];
    }
}