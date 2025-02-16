from collections import deque
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        if not m or not n: return 0

        queue = deque()
        fresh_oranges = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh_oranges += 1
                elif grid[i][j] == 2:
                    queue.append((i,j))
        
        if not fresh_oranges: return 0
        if not queue: return -1

        minutes = -1
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        while queue:
            size = len(queue)
            minutes += 1

            while size:
                size -= 1
                _i, _j = queue.popleft()
                for dir in dirs:
                    i = _i + dir[0]
                    j = _j + dir[1]

                    if i>=0 and j>=0 and i<m and j<n and grid[i][j]==1:
                        grid[i][j] = 2
                        fresh_oranges -= 1
                        queue.append((i,j))
        
        if fresh_oranges > 0: return -1
        return minutes

                
        


