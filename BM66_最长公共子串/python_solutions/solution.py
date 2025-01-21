#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# longest common substring
# @param str1 string字符串 the string
# @param str2 string字符串 the string
# @return string字符串
#
class Solution:
    def LCS(self , str1: str, str2: str) -> str:
        dp =[[0 for _ in range(len(str2) + 1)] for __ in range(len(str1)+1)]
        max = 0
        position = 0

        for i in range(1, len(str1) + 1):
            for j in range(1, len(str2) + 1):
                if str1[i-1] == str2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = 0
                
                if dp[i][j] > max:
                    max = dp[i][j]
                    position = i
        
        return str1[position-max : position]


