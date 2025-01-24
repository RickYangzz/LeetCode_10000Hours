#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param a int整型一维数组 
# @param n int整型 
# @param K int整型 
# @return int整型
#
from typing import List


class Solution:
    def findKth(self , a: List[int], n: int, K: int) -> int:
        return self.quickSort(a, 0, n-1, K)

    def quickSort(self, a: List[int], low: int, high: int, k: int) -> int:
        splitSpot = self.partition(a, low, high)

        if splitSpot + 1 == k:
            return a[splitSpot]
        elif splitSpot + 1 < k:
            return self.quickSort(a, splitSpot+1, high, k)
        else:
            return self.quickSort(a, low, splitSpot-1, k)
    
    def partition(self, a: List[int], low: int, high: int) -> int:
        splitValue = a[low]

        while low < high:
            while low < high and a[high] < splitValue:
                high -= 1
            a[low] = a[high]

            while low < high and a[low] >= splitValue:
                low += 1
            a[high] = a[low]

        a[low] = splitValue

        return low
        