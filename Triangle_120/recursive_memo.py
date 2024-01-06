class Solution:
    triangle: None
    dp: None

    def minimumTotal(self, triangle) -> int:
        self.triangle = triangle
        rows = len(triangle)
        cols = len(triangle[rows-1])
        self.dp = self.get2dArray(rows, cols)

        return self.minPath(0,0)

    def minPath(self, row, col):
        if (row+1) == len(self.triangle): 
            self.dp[row][col] = self.triangle[row][col]

        if self.dp[row][col] is not None: return self.dp[row][col]

        self.dp[row][col] = self.triangle[row][col] + min(self.minPath(row+1, col), self.minPath(row+1, col+1))

        return self.dp[row][col]

    def get2dArray(self, rows, cols):
        return [[None for i in range(cols)] for j in range(rows)]