#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param number int整型 
# @return int整型
#
class Solution:
    def jumpFloor(self , number: int) -> int:
        if number <= 1: return 1

        f0 = 1
        f1 = 1
        fn = 1

        for _ in range(2, number+1):
            fn = f1 + f0

            f0 = f1
            f1 = fn
        
        return fn