#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param n int整型 
# @return int整型
#
class Solution:
    def Fibonacci(self , n: int) -> int:
        if n == 1 or n == 2: return 1

        record = [0] * (n + 1)  # 初始化列表，确保其有 n+1 个元素
        record[1] = 1 # 设置第一个 Fibonacci 数值
        record[2] = 1 # 设置第二个 Fibonacci 数值

        for i in range(3, n+1):
            record[i] = record[i-1] + record[i-2]

        return record[n]
