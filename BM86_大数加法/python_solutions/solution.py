
class Solution:
    def solve(self , s: str, t: str) -> str:
        if not s : return t
        if not t : return s

        sLen = len(s)
        tLen = len(t)

        strBuilder = []
        carry = 0
        for i in range(1, max(sLen, tLen)+1):
            a = int(s[sLen - i]) if sLen - i >= 0 else 0
            b = int(t[tLen - i]) if tLen - i >= 0 else 0
            sum = a + b + carry
            carry = sum // 10
            value = sum % 10

            strBuilder.append(str(value))
        
        if carry > 0:
            strBuilder.append("1")

        strBuilder.reverse()
        return "".join(strBuilder)
