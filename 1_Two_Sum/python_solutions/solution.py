class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        store_map = {}

        for i in range(len(nums)):
            complement = target - nums[i]

            if complement in store_map:
                return [store_map[complement], i]
            
            store_map[nums[i]] = i
        
        return []