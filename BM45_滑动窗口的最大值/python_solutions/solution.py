from typing import List

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param num int整型一维数组 
# @param size int整型 
# @return int整型一维数组
#
class Solution:
    def maxInWindows(self , num: List[int], size: int) -> List[int]:
        if not num or not size or size > len(num) :return []
        if size == 1: return num

        result = []
        deque = []

        for i in range(len(num)):
            while deque and num[deque[-1]] <= num[i]:
                deque.pop(-1)
            
            deque.append(i)

            windowStart = i + 1 - size

            while deque and deque[0] < windowStart:
                deque.pop(0)

            if deque and windowStart >= 0:
                result.append(num[deque[0]])
        
        return result
