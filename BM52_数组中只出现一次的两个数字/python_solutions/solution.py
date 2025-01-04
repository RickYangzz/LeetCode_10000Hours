#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param nums int整型一维数组 
# @return int整型一维数组
#
from typing import List


class Solution:
    def FindNumsAppearOnce(self , nums: List[int]) -> List[int]:
        temp = 0
        for i in nums:
            temp ^= i

        k = 1
        while (k&temp) == 0:
            k <<= 1
        
        res1 = 0
        res2 = 0
        for i in nums:
            if (k&i) == 0: res1 ^= i
            else: res2 ^= i

        if res1 < res2: return [res1, res2]
        else: return [res2, res1]
        