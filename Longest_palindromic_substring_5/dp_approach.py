class Solution:
    dp = None
    s =  ""
    result = ""

    def longestPalindrome(self, s: str) -> str:
        if len(s) < 1: return self.result

        self.init(s)
        
        for start in range(len(s)-1, -1, -1):
            for end in range(start, len(s)):
                if self.isPalindrome(start, end): self.record(start, end)
        
        return self.result

    def init(self, s):
        self.s = s
        rows = cols = len(s)
        self.dp = [[False for i in range(cols)] for j in range(rows)]
    
    def isPalindrome(self, start, end):
        if start == end: return True

        return self.s[start] == self.s[end] and (
            end - start == 1 or self.dp[start+1][end-1] == True
        )
    
    def record(self, start, end):
        self.dp[start][end] = True
        if (end - start) >= len(self.result):
            self.result = self.s[start: end+1]
        
