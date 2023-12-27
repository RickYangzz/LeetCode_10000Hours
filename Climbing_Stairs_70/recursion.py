class Solution:
    memo = {}

    def climbStairs(self, n: int) -> int:
        if n <= 1: return 1

        if (n not in self.memo):
            self.memo[n] = self.climbStairs(n-1) + self.climbStairs(n-2)
        
        return self.memo[n]
