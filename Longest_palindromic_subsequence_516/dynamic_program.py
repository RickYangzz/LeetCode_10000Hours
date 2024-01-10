class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        rows = cols = len(s)
        dp = [[0 for i in range(cols)] for j in range(rows)]

        for start in range(rows-1, -1, -1):
            dp[start][start] = 1
            for end in range(start + 1, cols):
                if s[start] == s[end]: dp[start][end] = 2 + dp[start+1][end-1]
                else: dp[start][end] = max(dp[start+1][end], dp[start][end-1])
        
        return dp[0][cols-1]
