class Solution:
    def deleteAndEarn(self, nums):
        if not nums: return 0

        temp_arr = [0] * (max(nums) + 1)
        for n in nums:
            temp_arr[n] += n
        
        prev_0 = 0
        prev_1 = temp_arr[1]
        
        for i in range(2, len(temp_arr)):
            current = max(temp_arr[i] + prev_0, prev_1)
            prev_0 = prev_1
            prev_1 = current

        return prev_1

aSolution = Solution()

result = aSolution.deleteAndEarn(nums=[10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,4,3,8,4,10,8,8,10,6,4,4,4,9,6,9,10,7,1,5,3,4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5])

print(result == 338)