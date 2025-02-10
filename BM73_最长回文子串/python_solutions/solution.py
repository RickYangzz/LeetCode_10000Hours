class Solution:
    def getLongestPalindrome(self , s: str) -> int:
        n = len(s)
        if n == 0:
            return 0
        if n == 1:
            return 1

        max_len = 1

        for i in range(1, n):
            current_length = max(self.diffusion(s, i, i), self.diffusion(s, i, i-1))
            max_len = max(max_len, current_length)

        return max_len
    
    def diffusion(self, s: str, left: int, right: int) -> int:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        
        return right - left - 1
