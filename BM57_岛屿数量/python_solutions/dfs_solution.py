from typing import List

class Solution:
    def solve(self , grid: List[List[str]]) -> int:
        result = 0

        if not len(grid) or not len(grid[0]): return result

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] != '1': continue

                result += 1
                self.dfs(grid, i, j)
        
        return result
    
    def dfs(self, grid: List[List[str]], i: int, j: int)->None:
        grid[i][j] = '0'

        if i-1 >= 0 and grid[i-1][j] == '1': self.dfs(grid, i-1, j)
        if j-1 >= 0 and grid[i][j-1] == '1': self.dfs(grid, i, j-1)
        if i+1 < len(grid) and grid[i+1][j] == '1': self.dfs(grid, i+1, j)
        if j+1 < len(grid[i]) and grid[i][j+1] == '1':self.dfs(grid, i, j+1)