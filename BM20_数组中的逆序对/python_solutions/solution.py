from typing import List

class Solution:
    def InversePairs(self, nums: List[int]) -> int:
        # 如果数组长度小于2，直接返回0
        if len(nums) < 2:
            return 0

        count = [0]  # 使用列表包装计数器
        self.mergeSort(nums, 0, len(nums) - 1, count)
        return count[0] % 1000000007
    
    def mergeSort(self, nums: List[int], start: int, end: int, count: List[int]) -> None:
        # 如果当前子数组只有一个元素，直接返回
        if start >= end:
            return

        # 找到中间位置，进行递归分治
        middle = (start + end) // 2
        self.mergeSort(nums, start, middle, count)
        self.mergeSort(nums, middle + 1, end, count)

        # 合并两个已排序的子数组，并统计逆序对
        self.merge(nums, start, middle, end, count)
    
    def merge(self, nums: List[int], start: int, middle: int, end: int, count: List[int]) -> None:
        # 临时数组存储合并结果
        tempArr = [0] * (end - start + 1)
        
        i = 0  # 临时数组的索引
        l = start  # 左子数组的起始索引
        r = middle + 1  # 右子数组的起始索引

        # 合并过程，统计逆序对
        while l <= middle and r <= end:
            if nums[l] <= nums[r]:
                tempArr[i] = nums[l]
                i += 1
                l += 1
            else:
                tempArr[i] = nums[r]
                count[0] += (middle - l + 1)  # 计算逆序对个数
                count[0] %= 1000000007  # 取模
                i += 1
                r += 1
        
        # 处理左子数组中剩余的元素
        while l <= middle:
            tempArr[i] = nums[l]
            i += 1
            l += 1
        
        # 处理右子数组中剩余的元素
        while r <= end:
            tempArr[i] = nums[r]
            i += 1
            r += 1
        
        # 将临时数组的结果复制回原数组
        for index in range(len(tempArr)):
            nums[start + index] = tempArr[index]
