#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 比较版本号
# @param version1 string字符串 
# @param version2 string字符串 
# @return int整型
#
class Solution:
    def compare(self , version1: str, version2: str) -> int:
        if not version1 and not version2: return 0
        if not version1: return -1
        if not version2: return 1

        i = 0
        j = 0

        while i < len(version1) or j < len(version2):
            sum1 = 0
            while i < len(version1) and version1[i] != '.':
                value = int(version1[i])
                sum1 = sum1*10 + value
                i += 1
            
            sum2 = 0
            while j < len(version2) and version2[j] != '.':
                value = int(version2[j])
                sum2 = sum2*10 + value
                j += 1
            
            if sum1 > sum2: return 1
            if sum1 < sum2: return -1
            
            i += 1
            j += 1
        
        return 0