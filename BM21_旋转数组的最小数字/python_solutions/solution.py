#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param nums int整型一维数组 
# @return int整型
#
class Solution:
    def minNumberInRotateArray(self , nums: List[int]) -> int:
        if not nums: return -1
        if len(nums) == 1: return nums[0]

        i = 0
        j = len(nums) - 1

        while i < j:
            middle = (i + j) // 2

            if nums[middle] > nums[j]:
                i = middle + 1
            elif nums[middle] == nums[j]:
                j -= 1
            else:
                j = middle
        
        return nums[j]