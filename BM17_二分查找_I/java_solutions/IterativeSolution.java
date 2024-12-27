package BM17_二分查找_I.java_solutions;

/**
 * 二分查找的迭代实现
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class IterativeSolution {
    /**
     * Binary Search
     * 二分查找
     * Implements binary search using iteration, locating the target value by continuously narrowing down the search range
     * 使用迭代方式实现二分查找，通过不断缩小查找范围来定位目标值
     * 
     * @param nums 升序排列的整数数组
     * @param target 要查找的目标值
     * @return 目标值在数组中的索引，如果不存在返回-1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;                          // 左边界
        int right = nums.length - 1;           // 右边界
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // 避免整数溢出的中点计算方式
            if (nums[mid] == target) {
                return mid;                    // 找到目标值
            } else if (nums[mid] < target) {
                left = mid + 1;               // 目标在右半部分
            } else {
                right = mid - 1;              // 目标在左半部分
            }
        }
        return -1;                            // 未找到目标值
    }
} 