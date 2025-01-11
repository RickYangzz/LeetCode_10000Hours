#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 验证IP地址
# @param IP string字符串 一个IP地址字符串
# @return string字符串
#
class Solution:
    def solve(self , IP: str) -> str:
        if self.isIPv4(IP): return "IPv4"
        if self.isIPv6(IP): return "IPv6"

        return "Neither"
    
    def isIPv4(self, IP: str) -> bool:
        if '.' not in IP: return False

        arr = IP.split('.')
        if len(arr) != 4: return False

        for subString in arr:
            if len(subString) == 0 or len(subString) > 3:
                return False

            if len(subString) > 1 and subString.startswith('0'):
                return False

            for c in subString:
                if c < "0" or c > "9": return False

            value = int(subString)
            if value < 0 or value > 255: return False
            
        return True

    def isIPv6(self, IP: str) -> bool:
        if ':' not in IP: return False

        arr = IP.split(':')
        if len(arr) != 8: return False

        for subString in arr:
            if len(subString) == 0 or len(subString) > 4: return False

            for c in subString:
                if not self.isHexChar(c): return False
            
        return True

    def isHexChar(self, c:str) -> bool:
        boolean09 = '0' <= c <= '9'
        booleanaf = 'a' <= c <= 'f'
        booleanAF = 'A' <= c <= 'F'

        return boolean09 or booleanaf or booleanAF

    