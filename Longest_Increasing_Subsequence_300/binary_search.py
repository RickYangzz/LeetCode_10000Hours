class Solution:
    def lengthOfLIS(self, nums) -> int:
        length = 0
        subsequence = [None for _ in range(len(nums))]
        subsequence[0] = nums[0]

        for currentNum in nums:
            
            if currentNum > subsequence[length]:
                length += 1
                subsequence[length] = currentNum
            else: # binary search
                middle = int(length/2)
                total = length
                flag = True
                while flag:
                    if currentNum <= subsequence[middle]:
                        if middle == 0 or currentNum > subsequence[middle-1]:
                            subsequence[middle] = currentNum
                            flag = False
                        else:
                            total = middle
                            middle = int(middle/2)
                    elif currentNum > subsequence[middle]:
                        if currentNum <= subsequence[middle+1]:
                            subsequence[middle+1] = currentNum
                            flag = False
                        else:
                            middle = int((total - middle)/2) + middle
        
        return length+1
        

aSolution = Solution()
result = aSolution.lengthOfLIS([10,9,2,5,3,7,101,18])
print(result)
