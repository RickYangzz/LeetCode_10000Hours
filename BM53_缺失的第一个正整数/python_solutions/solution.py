from typing import List

#
# 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
#
# 
# @param nums int整型一维数组 
# @return int整型
#
class Solution:
    def minNumberDisappeared(self , nums: List[int]) -> int:
        N = len(nums)

        for i in range(N):
            value = nums[i]
            if value <= 0: nums[i] = N + 1
        
        for i in range(N):
            value = abs(nums[i])
            if value <= N: 
                nums[value-1] = -1 * abs(nums[value-1])

        for i in range(N):
            value = nums[i]
            if value > 0: return i + 1
        
        return N + 1