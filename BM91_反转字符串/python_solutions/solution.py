#
# 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
#
# 反转字符串
# @param str string字符串 
# @return string字符串
#
class Solution:
    def solve(self , str: str) -> str:
        strArr = list(str)

        for i in range(len(strArr)//2):
            temp = strArr[i]
            strArr[i] = strArr[len(strArr) - i -1]
            strArr[len(strArr) - i -1] = temp
        
        return "".join(strArr)