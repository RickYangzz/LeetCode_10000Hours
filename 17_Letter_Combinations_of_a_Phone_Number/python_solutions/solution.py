from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits: return []

        keyboard = ['abc','def','ghi','jkl','mno','pqrs','tuv','wxyz']
        result = []

        def backtrack(combination, next_digits) -> None:
            if not next_digits:
                result.append(combination)
                return
            
            letters = keyboard[int(next_digits[0]) - 2]
            for s in letters:
                backtrack(combination+s, next_digits[1:])
        
        backtrack('', digits)
        return result


