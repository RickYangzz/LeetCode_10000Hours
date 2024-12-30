
import heapq
from typing import List

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 计算成功举办活动需要多少名主持人
#
# @param n int整型 有n个活动
# @param startEnd int整型二维数组 
#   startEnd[i][0]用于表示第i个活动的开始时间，
#   startEnd[i][1]表示第i个活动的结束时间
# @return int整型
#
class Solution:
    def minmumNumberOfHost(self , n: int, startEnd: List[List[int]]) -> int:
        startEnd.sort(key = lambda x: (x[0], x[1]))
        min_heap = []  # 使用 heapq 作为最小堆
        
        for activity in startEnd:
            if min_heap and min_heap[0] <= activity[0]:
                # 如果堆顶结束时间小于等于当前活动的开始时间，则复用该主持人，移除掉堆顶元素。
                heapq.heappop(min_heap)
            # 将当前活动的结束时间加入堆
            heapq.heappush(min_heap, activity[1])

        return len(min_heap)
    