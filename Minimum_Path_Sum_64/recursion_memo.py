class Solution:
    dp: None
    grid: None

    def minPathSum(self, grid) -> int:
        rows = len(grid)
        cols = len(grid[0])
        self.grid = grid
        self.dp = self.get2dArray(rows, cols)

        return self.minPath(rows, cols)
    
    def minPath(self, rows, cols) -> int:
        if rows == 1: 
            result = 0
            for i in range(cols): result += self.grid[0][i]
            self.dp[rows-1][cols-1] = result
        
        if cols == 1: 
            result = 0
            for i in range(rows): result += self.grid[i][0]
            self.dp[rows-1][cols-1] = result

        if self.dp[rows-1][cols-1] != None: 
            return self.dp[rows-1][cols-1]

        self.dp[rows-1][cols-1] = self.grid[rows-1][cols-1] + min(self.minPath(rows-1, cols), self.minPath(rows, cols-1))

        return self.dp[rows-1][cols-1]

    def get2dArray(self, rows, cols):
        return [[None for i in range(cols)] for j in range(rows)]
    

aSolution = Solution()
result = aSolution.minPathSum([[1,3,1],[1,5,1],[4,2,1]])
print(result)
