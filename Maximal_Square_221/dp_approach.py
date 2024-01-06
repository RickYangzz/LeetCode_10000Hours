class Solution:
    def maximalSquare(self, matrix) -> int:
        if matrix is None or len(matrix) < 1: return 0

        rows = len(matrix)
        cols = len(matrix[0])

        dp = [[0 for i in range(cols+1)] for j in range(rows+1)]
        max_size = 0

        for m in range(rows):
            for n in range(cols):
                if matrix[m][n] == "1":
                    dp[m+1][n+1] = min(dp[m+1][n], dp[m][n], dp[m][n+1]) + 1
                    max_size = max(max_size, dp[m+1][n+1])

        return max_size * max_size
