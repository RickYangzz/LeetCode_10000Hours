class Solution:
    def solve(self , nums: str) -> int:
        if nums == '0': return 0
        if len(nums) == 1: return 1

        dp = [1 for _ in range(len(nums) + 1)]

        for i in range(2, len(nums) + 1):
            if nums[i-1] == '0' and nums[i-2] != '1' and nums[i-2] != '2':
                return 0
            
            if nums[i-1] == '0' and (nums[i-2] == 1 or nums[i-2] == 2) :
                dp[i] = dp[i-2]
                continue

            if (nums[i-1] > '0' and nums[i-2] == '1') or (nums[i-1] > '0' and nums[i-2] == '2' and nums[i-1] < '7'):
                dp[i] = dp[i-1] + dp[i-2]
                continue

            dp[i] = dp[i-1]
        
        return dp[len(nums)]
