#
# 请写一个整数计算器，支持加减乘三种运算和括号。
#
# 返回表达式的值
# @param s string字符串 待计算的表达式
# @return int整型
#
class Solution:
    def solve(self , s: str) -> int:
        stack = []
        operate = '+'
        num = 0

        i = 0
        while i < (len(s)):
            current = s[i]

            if '0' <= current and current <= '9':
                num = num*10 + int(current)
                if i != len(s)-1: 
                    i+=1
                    continue
            
            if current == '(':
                balance = 1
                start = i + 1

                while balance != 0:
                    i += 1
                    if s[i] == '(': balance += 1
                    if s[i] == ')': balance -= 1
                
                num = self.solve(s[start:i])
                current = s[i]
                if i != len(s)-1: 
                    i+=1
                    continue
            
            if operate == '+':
                stack.append(num)
            elif operate == '-':
                stack.append(-num)
            elif operate == '*':
                stack.append(stack.pop() * num)

            num = 0
            i+=1

            if current == ')':
                continue
            else:
                operate = current
        
        result = 0
        while stack:
            result += stack.pop()
        return result

