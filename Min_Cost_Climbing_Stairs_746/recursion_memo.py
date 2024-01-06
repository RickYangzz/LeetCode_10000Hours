class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [None] * n
        dp[0] = cost[0]
        dp[1] = cost[1]

        return min(self.minCost(n - 1, cost, dp), self.minCost(n - 2, cost, dp))

    def minCost(self, n: int, cost: List[int], dp: List[int]) -> int:
        if (n == 0 or n == 1): return cost[n]
        if(dp[n] != None): return dp[n]
        
        dp[n] = cost[n] + min(
            self.minCost(n - 1, cost, dp), 
            self.minCost(n - 2, cost, dp)
        )

        return dp[n]