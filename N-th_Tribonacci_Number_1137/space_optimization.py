class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0: return 0
        if n == 1: return 1
        if n == 2: return 1

        t_0 = 0
        t_1 = 1
        t_2 = 1
        
        t_n = 0

        for i in range(3, n+1):
            t_n = t_0 + t_1 + t_2
            
            t_0 = t_1
            t_1 = t_2
            t_2 = t_n
        
        return t_n
