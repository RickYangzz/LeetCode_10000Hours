class Solution:
    def getLongestPalindrome(self , s: str) -> int:
        mp = [1 for _ in range(len(s) * 2 + 2)]

        self.calculate(s, mp)

        max_len = 0
        for i in range(len(mp)):
            max_len = max(max_len, mp[i] - 1)
        
        return max_len
    
    def calculate(self, s: str, mp: List[int]) -> None:
        ms = '$#'
        for i in range(len(s)):
            ms += s[i]
            ms += '#'
        
        right_side = 0
        index = 0
        for i in range(len(mp)):
            mp[i] = min(mp[2*index - i], right_side - i) if right_side > i else 1
            while i - mp[i] >= 0 and i + mp[i] < len(mp) and ms[i-mp[i]] == ms[i+mp[i]]:
                mp[i] += 1
            
            if i + mp[i] > right_side:
                right_side = i + mp[i]
                index = i
        