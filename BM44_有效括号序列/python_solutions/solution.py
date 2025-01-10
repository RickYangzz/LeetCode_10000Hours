#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param s string字符串 
# @return bool布尔型
#
class Solution:
    def isValid(self , s: str) -> bool:
        stack = []

        for element in s:
            if element == '(':
                stack.append(')')
            elif element == '[':
                stack.append(']')
            elif element == '{':
                stack.append('}')
            elif len(stack) == 0 or stack.pop() != element:
                return False
        
        return len(stack) == 0