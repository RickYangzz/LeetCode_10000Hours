#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 旋转数组
# @param n int整型 数组长度
# @param m int整型 右移距离
# @param a int整型一维数组 给定数组
# @return int整型一维数组
#
from typing import List


class Solution:
    def solve(self , n: int, m: int, a: List[int]) -> List[int]:
        if n == 0 or not a: return a

        m = m%n
        if m == 0: return a

        self.reverse(a, 0, n-1)
        self.reverse(a, 0, m-1)
        self.reverse(a, m, n-1)
        
        return a

    def reverse(self, a: List[int], start: int, end: int) -> None:
        while start < end:
            temp = a[end]
            a[end] = a[start]
            a[start] = temp

            start+=1
            end-=1
