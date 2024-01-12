class Solution:
    def minDistance(self, word1: str, word2: str, i=0, j=0, memo=None) -> int:
        if not word1: return len(word2)
        if not word2: return len(word1)

        rows = len(word1)
        cols = len(word2)

        dp = [[0 for __ in range(cols + 1)] for _ in range(rows + 1)]

        for i in range(rows + 1):
            dp[i][0] = i
        for j in range(cols + 1):
            dp[0][j] = j

        for i in range(1, rows+1):
            for j in range(1, cols+1):
                if word1[i-1] == word2[j-1]: 
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])

        return dp[-1][-1]
