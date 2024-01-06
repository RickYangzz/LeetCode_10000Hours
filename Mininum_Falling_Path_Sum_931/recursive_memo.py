class Solution:
    dp: None
    matrix: None

    def minFallingPathSum(self, matrix) -> int:
        rows = cols = len(matrix)
        self.dp = self.get2dArray(rows, cols)
        self.matrix = matrix

        for i in range(cols): self.miniPath(0,i)

        return min(self.dp[0])
    
    def miniPath(self, row, col):
        if row == (len(self.matrix) - 1):
            self.dp[row][col] = self.matrix[row][col]

        if self.dp[row][col] != None: return self.dp[row][col]

        if col == 0:
            self.dp[row][col] = self.matrix[row][col] + min(
                self.miniPath(row+1, col), 
                self.miniPath(row+1, col+1)
            )
        elif col == (len(self.matrix) - 1):
            self.dp[row][col] = self.matrix[row][col] + min(
                self.miniPath(row+1, col-1), 
                self.miniPath(row+1, col)
            )
        else:
            self.dp[row][col] = self.matrix[row][col] + min(
                self.miniPath(row+1, col-1), 
                self.miniPath(row+1, col), 
                self.miniPath(row+1, col+1)
            )
        
        return self.dp[row][col]

    def get2dArray(self, rows, cols):
        return [[None for i in range(cols)] for j in range(rows)]

aSolution = Solution()
result = aSolution.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]])
print(result)