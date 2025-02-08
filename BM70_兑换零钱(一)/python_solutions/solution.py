# 最少货币数
#
# @param arr int整型一维数组 the array
# @param aim int整型 the target
# @return int整型
#
class Solution:
    def minMoney(self , arr: List[int], aim: int) -> int:
        dp = [(aim + 1) for _ in range(aim + 1)]
        dp[0] = 0

        for i in range(1, aim + 1):
            for price in arr:
                if price <= i:
                    dp[i] = min(dp[i], dp[i - price] + 1)

        return dp[aim] if dp[aim] <= aim else -1