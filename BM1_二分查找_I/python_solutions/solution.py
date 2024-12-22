class Solution:
    def search(self, nums: list[int], target: int) -> int:
        """
        二分查找
        :param nums: 有序数组
        :param target: 目标值
        :return: 目标值在数组中的索引，如果不存在返回-1
        """
        if not nums:
            return -1
            
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
                
        return -1 