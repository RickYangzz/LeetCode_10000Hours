from typing import List

class Solution:
    def generateParenthesis(self , n: int) -> List[str]:
        result: List[str] = []
        
        self.recursion(result, 0, 0, n, "")

        return result

    def recursion(self, result: List[str], left: int, right: int, n: int, temp: str) -> None:
        if left == n and right == n:
            result.append(temp)
            return
        
        if left < n :
            self.recursion(result, left+1, right, n, temp+"(")
        
        if right < n and right < left:
            self.recursion(result, left, right + 1, n, temp+")")

