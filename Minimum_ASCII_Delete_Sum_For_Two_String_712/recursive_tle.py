class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        result = 0

        if not s1: 
            for i in s2:
                result += ord(i)
            return result
        if not s2: 
            for i in s1:
                result += ord(i)
            return result


        if s1[0] == s2[0]:
            result = self.minimumDeleteSum(s1[1:], s2[1:])
        else:
            s1_result = ord(s1[0]) + self.minimumDeleteSum(s1[1:], s2)
            s2_result = ord(s2[0]) + self.minimumDeleteSum(s1, s2[1:])

            result = min(s1_result, s2_result)
        
        return result


aSolution = Solution()
result = aSolution.minimumDeleteSum("sea", "eat")
print(result)
