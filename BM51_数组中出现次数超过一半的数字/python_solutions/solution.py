
from typing import List

class Solution:
    def MoreThanHalfNum_Solution(self , numbers: List[int]) -> int:
        candidate = -1
        count = 0

        for num in numbers:
            if(count == 0):
                candidate = num
            
            if(candidate == num):
                count+=1
            else:
                count-=1
        
        count=0
        for num in numbers:
            if num == candidate:
                count+=1
            
        if count > len(numbers)/2: return candidate
        return -1