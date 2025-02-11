from typing import List

class Solution:
    def __init__(self):
        self.example = ["" for _ in range(4)]

    def restoreIpAddresses(self , s: str) -> List[str]:
        result = []
        self.recursive(s, 0, 0, result)
        return result
    
    def recursive(self, s: str, step: int, index: int, result: List[str]) -> None:
        if step is 4:
            if index is len(s):
                result.append(".".join(self.example))
            return
        
        current = ""
        i = index
        while i < len(s) and i < index+3:
            current += s[i]

            if self.isIPNumber(current):
                self.example[step] = current
                self.recursive(s, step+1, i+1, result)
            
            i += 1
    
    def isIPNumber(self, current: str)-> bool:
        return int(current) <= 255 and (len(current) == 1 or current[0] != '0')