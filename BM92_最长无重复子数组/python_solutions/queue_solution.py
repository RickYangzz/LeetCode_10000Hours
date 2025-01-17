from typing import List

class Solution:
    def maxLength(self, arr: List[int]) -> int:
        max_len = 0
        queue = []

        for value in arr:
            while value in queue:
                queue.pop(0)
            
            queue.append(value)

            max_len = max(max_len, len(queue))

        return max_len