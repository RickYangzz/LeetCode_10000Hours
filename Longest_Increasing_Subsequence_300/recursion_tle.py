class Solution:
    def lengthOfLIS(self, nums) -> int:
        return self.solve(nums, 0, -2^63)
    
    def solve(self, nums, i, prev):
        if i == len(nums): return 0
        
        if nums[i] > prev:
            pickNum = 1 + self.solve(nums, i+1, nums[i])
            skipNum = self.solve(nums, i+1, prev)
            return max(pickNum, skipNum)
        else:
            return self.solve(nums, i+1, prev)
