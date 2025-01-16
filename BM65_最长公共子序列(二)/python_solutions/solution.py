from typing import List

class Solution:
    def LCS(self , s1: str, s2: str) -> str:
        # 如果任意一个字符串为空，返回 "-1"
        if not s1 or not s2: 
            return "-1"

        # 初始化 dp 数组，用于记录最长公共子序列的长度
        # dp[i][j] 表示 s1[0..i-1] 和 s2[0..j-1] 的 LCS 长度
        dp = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]
        
        # 初始化 direction 数组，用于记录构造 LCS 时的方向
        # direction[i][j] 表示在 dp[i][j] 计算过程中是来自哪一方向
        direction = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]

        # 动态规划填充 dp 和 direction 数组
        for i in range(1, len(s1) + 1):
            for j in range(1, len(s2) + 1):
                # 如果 s1[i-1] 和 s2[j-1] 相同，LCS 长度加 1
                if s1[i-1] == s2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                    direction[i][j] = 1  # 方向来自左上方
                    continue

                # 如果左边的值大于上边的值，LCS 长度继承左边
                if dp[i][j-1] > dp[i-1][j]:
                    dp[i][j] = dp[i][j-1]
                    direction[i][j] = 2  # 方向来自左边
                else:
                    dp[i][j] = dp[i-1][j]
                    direction[i][j] = 3  # 方向来自上边

        # 通过 direction 数组和 s1 还原出最长公共子序列
        result = self.buildLCS(direction, s1, len(s1), len(s2))

        # 如果结果为空，则返回 "-1"
        return result or "-1"
    
    def buildLCS(self, direction: List[List[int]], s1: str, i: int, j: int) -> str:
        # strBuilder 用于构建最终的 LCS 字符串
        strBuilder = []

        # 从 direction 数组中回溯构建 LCS
        while i > 0 and j > 0:
            # 如果当前方向是 1，说明字符匹配，将字符添加到结果中
            if direction[i][j] == 1:
                strBuilder.append(s1[i-1])  # 添加当前匹配的字符
                i -= 1
                j -= 1
            # 如果当前方向是 2，说明从左边继承，j 减少
            elif direction[i][j] == 2:
                j -= 1
            # 如果当前方向是 3，说明从上边继承，i 减少
            else:
                i -= 1
    
        # 因为是从后往前构建的 LCS，所以需要反转字符串
        strBuilder.reverse()
        return "".join(strBuilder)  # 返回最终的 LCS 字符串
