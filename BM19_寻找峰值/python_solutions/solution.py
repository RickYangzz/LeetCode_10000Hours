from typing import List

class Solution:
    def findPeakElement(self , nums: List[int]) -> int:
        start = 0
        end = len(nums) - 1

        while start < end:
            mid = (start + end) // 2  # 使用整除运算符

            if nums[mid] < nums[mid+1]:
                start = mid + 1
            else:
                end = mid
        
        return start