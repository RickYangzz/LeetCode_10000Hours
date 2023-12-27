class Solution:
    def fib(self, n: int) -> int:
        if n == 0: return 0
        if n == 1: return 1

        dpt = [0] * (n+1)
        dpt[0] = 0
        dpt[1] = 1
 
        for i in range(2, n+1):
            dpt[i] = dpt[i-1] + dpt[i-2]
        
        return dpt[n]
        