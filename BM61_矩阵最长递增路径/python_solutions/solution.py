#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 递增路径的最大长度
# @param matrix int整型二维数组 描述矩阵的每个数
# @return int整型
#
from typing import List


class Solution:
    n = 0
    m = 0
    direction = [[-1, 0],[1,0],[0,-1],[0,1]]
    
    def solve(self , matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]: return 0

        self.n = len(matrix)
        self.m = len(matrix[0])
        dp: List[List[int]] = [[0 for _ in range(self.m)] for __ in range(self.n)]

        res = 0
        for i in range(self.n):
            for j in range(self.m):
                res = max(res, self.dfs(matrix, dp, i, j))
        
        return res
    
    def dfs(self, matrix: List[List[int]], dp: List[List[int]], i: int, j: int) -> int:
        if dp[i][j]:
            return dp[i][j]
        
        dp[i][j] = 1

        for k in range(4):
            nexti = i + self.direction[k][0]
            nextj = j + self.direction[k][1]

            if nexti >= 0 and nexti < self.n and nextj >= 0 and nextj < self.m and matrix[nexti][nextj] > matrix[i][j]:
                dp[i][j] = max(dp[i][j], self.dfs(matrix, dp, nexti, nextj) + 1)
        
        return dp[i][j]