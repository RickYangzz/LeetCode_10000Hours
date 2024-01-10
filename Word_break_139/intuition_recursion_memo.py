class Solution:
    wordDict = None
    dp = None

    def wordBreak(self, s: str, wordDict) -> bool:
        self.wordDict = wordDict
        self.dp = {}

        return self.isTrue(s)

    def isTrue(self, s):
        for i in range(len(s)):
            currentStr =  s[0:(i+1)]
            if currentStr in self.wordDict:
                if i == (len(s) - 1): return True
                
                leftStr = s[(i+1):]

                if leftStr not in self.dp.keys():
                    self.dp[leftStr] = self.isTrue(leftStr)
                
                if self.dp[leftStr]: return True
            
        return False


aSolution = Solution()
result = aSolution.wordBreak("leetcode", ["leet","code"])
print(result)