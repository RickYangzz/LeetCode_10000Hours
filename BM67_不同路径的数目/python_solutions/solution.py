#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param m int整型 
# @param n int整型 
# @return int整型
#
class Solution:
    def uniquePaths(self , m: int, n: int) -> int:
        dp = [[1 for _ in range(n+1)] for __ in range(m+1)]

        for i in range(2, m+1):
            for j in range(2, n+1):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[m][n]