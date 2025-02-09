#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 给定数组的最长严格上升子序列的长度。
# @param arr int整型一维数组 给定的数组
# @return int整型
#
class Solution:
    def LIS(self , arr: List[int]) -> int:
        if len(arr) == 0: return 0
        if len(arr) == 1: return 1

        dp = [1 for _ in range(len(arr))]
        result = 0

        for i in range(1, len(arr)):
            for j in range(i):
                if arr[j] < arr[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    result = max(result, dp[i])
        
        return result