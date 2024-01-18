class Solution:
    def lengthOfLIS(self, nums) -> int:
        rows = cols = len(nums)
        dp = [[0 for _ in range(cols+1)] for __ in range(rows+1)]

        for i in range(rows-1, -1, -1):
            for j in range(cols+1):
                if j == cols or nums[i] > nums[j]:
                    pickNum = 1 + dp[i+1][i]
                    skipNum = dp[i+1][j]
                    dp[i][j] = max(pickNum, skipNum)
                else:
                    dp[i][j] = dp[i+1][j]

        return dp[0][-1]

aSolution = Solution()
result = aSolution.lengthOfLIS([10,9,2,5,3,7,101,18])
print(result)
