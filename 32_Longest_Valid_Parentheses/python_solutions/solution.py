class Solution:
    def longestValidParentheses(self, s: str) -> int:
        dp = [0] * len(s)
        max_length = 0

        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    dp[i] = (dp[i-2] if i-2 >= 0 else 0) + 2
                elif i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1] == '(':
                    dp[i] = dp[i-1] + 2 + (dp[i-dp[i-1]-2] if i-dp[i-1]-2 >= 0 else 0)

                max_length = max(max_length, dp[i])
        
        return max_length