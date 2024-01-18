class Solution:
    dp = None

    def lengthOfLIS(self, nums) -> int:
        self.dp = [[-1 for _ in range(len(nums)+1)] for __ in range(len(nums))]

        result = self.solve(nums, 0, -1)

        return result
    
    def solve(self, nums, i, prev_j):

        if i == len(nums): return 0

        if self.dp[i][prev_j] > -1: return self.dp[i][prev_j]
        
        if (prev_j == -1) or (nums[i] > nums[prev_j]):
            pickNum = 1 + self.solve(nums, i+1, i)
            skipNum = self.solve(nums, i+1, prev_j)
            self.dp[i][prev_j] = max(pickNum, skipNum)
        else:
            self.dp[i][prev_j] = self.solve(nums, i+1, prev_j)
        
        return self.dp[i][prev_j]

aSolution = Solution()
result = aSolution.lengthOfLIS([10,9,2,5,3,7,101,18])
print(result)
