#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param input int整型一维数组 
# @param k int整型 
# @return int整型一维数组
#
import heapq
from typing import List

class Solution:
    def GetLeastNumbers_Solution(self , input: List[int], k: int) -> List[int]:
        if not input or len(input) == 0 or k == 0: return []

        pq: List[int] = []

        for i in range(k):
            heapq.heappush(pq, -1 * input[i])

        for i in range(k, len(input)):
            if input[i] < (-1 * pq[0]):
                heapq.heapreplace(pq, -1 * input[i])
        
        result = []
        while pq:
            result.append(-1 * heapq.heappop(pq))
        
        return result
