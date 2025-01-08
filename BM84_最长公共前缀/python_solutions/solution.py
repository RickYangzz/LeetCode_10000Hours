from typing import List

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param strs string字符串一维数组 
# @return string字符串
#
class Solution:
    def longestCommonPrefix(self , strs: List[str]) -> str:
        if not len(strs): return ""

        result = strs[0]
        for string in strs:
            result = self.getCommonPrefix(result, string)

        return result
    
    def getCommonPrefix(self, first: str, second: str) -> str:
        minLength = min(len(first), len(second))

        end = 0
        while end < minLength and first[end] == second[end]:
            end += 1
        
        return first[:end]