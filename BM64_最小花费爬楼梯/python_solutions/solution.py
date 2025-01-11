from typing import List


class Solution:
    def minCostClimbingStairs(self , cost: List[int]) -> int:
        length = len(cost)
        
        for i in range(2, length):
            cost[i] = min(cost[i-1], cost[i-2]) + cost[i]
        
        return min(cost[length-1], cost[length-2])