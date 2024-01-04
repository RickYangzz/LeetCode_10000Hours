class Solution:
    og: None
    dp: None

    def uniquePathsWithObstacles(self, obstacleGrid) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        self.og = obstacleGrid
        self.dp = self.get2dArray(m,n)

        self.dp[m-1][n-1] = self.path(m,n)
        return self.dp[m-1][n-1]

    def path(self, m, n):
        # boundary conditions
        if self.og[m-1][n-1] == 1: 
            self.dp[m-1][n-1] = 0
            return 0

        if m == 1:
            for i in range(n):
                if self.og[0][i] == 1: 
                    self.dp[0][n-1] = 0
                    return 0
            self.dp[m-1][n-1] = 1
        
        if n == 1:
            for i in range(m):
                if self.og[i][0] == 1: 
                    self.dp[m-1][0] = 0
                    return 0
            self.dp[m-1][n-1] = 1
        
        # dp cache
        if self.dp[m-1][n-1] != None: return self.dp[m-1][n-1]

        self.dp[m-1][n-1] = self.path(m-1, n) + self.path(m, n-1)

        return self.dp[m-1][n-1]
    
    def get2dArray(self, m, n):
        return [[None for i in range(n)] for j in range(m)]



aSolution = Solution()
result = aSolution.uniquePathsWithObstacles([[0,0,0],[0,1,0],[0,0,0]])
print(result)