class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        result = 0
        if not s1: 
            for i in s2:
                result += ord(i)
            return result
        if not s2: 
            for i in s1:
                result += ord(i)
            return result

        rows = len(s1)
        cols = len(s2)

        dp = [[0 for _ in range(cols+1)] for __ in range(rows+1)]

        dp[rows][cols] = 0
        for j in range(cols-1, -1, -1):
            dp[rows][j] = ord(s2[j]) + dp[rows][j+1]
        for i in range(rows-1, -1, -1):
            dp[i][cols] = ord(s1[i]) + dp[i+1][cols]
        
        for i in range(rows-1, -1, -1):
            for j in range(cols-1, -1, -1):
                if s1[i] == s2[j]: 
                    dp[i][j] = dp[i+1][j+1]
                else:
                    dp[i][j] = min(ord(s1[i]) + dp[i+1][j], ord(s2[j]) + dp[i][j+1])
        
        return dp[0][0]


aSolution = Solution()
result = aSolution.minimumDeleteSum("delete", "leet")
print(result)
