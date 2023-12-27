class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 1: return 1

        prev, curr = 1, 1

        for i in range(2, n+1):
            temp = curr
            curr = temp + prev
            prev = temp
        
        return curr
