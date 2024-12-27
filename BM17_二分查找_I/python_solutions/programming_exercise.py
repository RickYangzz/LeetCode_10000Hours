from typing import List

#
# 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，
# 写一个函数搜索 nums 中的 target，
# 如果目标值存在返回下标（下标从 0 开始），否则返回 -1
#
# 
# @param nums int整型一维数组 
# @param target int整型 
# @return int整型
#
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # Handle edge cases: if array is None or empty, return -1
        if nums == None or len(nums) == 0:
            return -1
        
        # Initialize two pointers for binary search
        left = 0                    # Left pointer starts at beginning of array
        right = len(nums) - 1       # Right pointer starts at end of array

        # Continue searching while left pointer doesn't cross right pointer
        while left <= right:
            # Calculate middle index
            # Using (right - left) // 2 instead of (right - left) / 2 
            # to ensure mid is an integer, which is important for index calculations.
            mid = left + (right - left) // 2

            # If target found at mid position, return its index
            if(nums[mid] == target):
                return mid
            
            # If middle element is smaller than target
            # search in right half of array
            if(nums[mid] < target):
                left = mid + 1
            
            # If middle element is larger than target
            # search in left half of array
            if(nums[mid] > target):
                right = mid - 1

        # If target not found in array, return -1
        return -1