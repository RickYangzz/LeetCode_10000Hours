package BM1_二分查找_I.java_solutions;

import java.util.Arrays;

/**
 * 二分查找的递归实现
 * 时间复杂度：O(log n)
 * 空间复杂度：O(log n) - 由于递归调用栈的开销
 */
public class RecursiveSolution {
    /**
     * 递归方式实现二分查找
     * Implement binary search using recursion
     * 通过将数组分成两半，递归地在相应的半部分中查找目标值
     * By dividing the array in half, recursively search for the target value in the corresponding half
     * 
     * @param nums 升序排列的整数数组
     * @param target 要查找的目标值
     * @return 目标值在数组中的索引，如果不存在返回-1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;                        // 处理空数组情况
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;  // 处理单元素数组

        int mid = nums.length / 2;
        if (nums[mid] == target)
            return mid;                       // 找到目标值

        if (nums[mid] < target) {
            // 在右半部分递归查找
            int targetIndex = search(Arrays.copyOfRange(nums, mid, nums.length), target);
            if (targetIndex > -1)
                return mid + targetIndex;     // 调整索引位置
        } else {
            // 在左半部分递归查找
            int targetIndex = search(Arrays.copyOfRange(nums, 0, mid), target);
            if (targetIndex > -1)
                return targetIndex;
        }

        return -1;                           // 未找到目标值
    }
}
