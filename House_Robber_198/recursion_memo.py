class Solution:
    dp: List[int | None] | None

    def rob(self, nums: List[int]) -> int:
        self.dp = [None] * len(nums)
        return self.recursion(nums, len(nums)-1)

    def recursion(self, nums: List[int], i: int) -> int:
        if i < 0: return 0
        
        if self.dp[i] != None: return self.dp[i]

        self.dp[i] = max(
            self.recursion(nums, i-2) + nums[i], 
            self.recursion(nums, i-1)
        )

        return self.dp[i]