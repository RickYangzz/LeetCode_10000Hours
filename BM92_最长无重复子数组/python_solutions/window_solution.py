from typing import List

class Solution:
    def maxLength(self, arr: List[int]) -> int:
        left = 0
        hash_map = {}
        max_len = 0

        for right in range(len(arr)):
            value = arr[right]

            if hash_map.get(value, 0):
                hash_map[value] += 1
            else:
                hash_map[value] = 1

            while hash_map[value] > 1:
                hash_map[arr[left]] -= 1
                left += 1

            max_len = max(max_len, right - left + 1)

        return max_len
