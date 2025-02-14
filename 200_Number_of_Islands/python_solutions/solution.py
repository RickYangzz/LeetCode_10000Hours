from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]: return 0

        result = 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if(grid[i][j] == '1'):
                    result += 1
                    self.dfs(grid, i, j)
        
        return result
    
    def dfs(self, grid: List[List[str]], i: int, j: int) -> None:
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[i]) or grid[i][j]!='1':
            return
        
        grid[i][j] = '0'
        self.dfs(grid, i-1, j)
        self.dfs(grid, i+1, j)
        self.dfs(grid, i, j-1)
        self.dfs(grid, i, j+1)
                