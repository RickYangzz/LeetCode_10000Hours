import heapq
from typing import List

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
        if not n or not startEnd: return 0

        start_arr = []
        end_arr = []

        for activity in startEnd:
            start_arr.append(activity[0])
            end_arr.append(activity[1])

        start_arr.sort()
        end_arr.sort()

        host, end_index = 0

        for start in start_arr:
            if start < end_arr[end_index]: host+=1
            else: end_index+=1

        return host
        
    