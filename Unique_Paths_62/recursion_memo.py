class Solution:
    dp_grid = None

    def uniquePaths(self, m: int, n: int) -> int:
        self.dp_grid = self.get2dArray(m, n)

        self.dp_grid[m-1][n-1] = self.path(m-1, n) + self.path(m, n-1)

        return self.dp_grid[m-1][n-1]

    def path(self, m: int, n: int) -> int:
        if m == 1 or n == 1: self.dp_grid[m-1][n-1] = 1

        if(self.dp_grid[m-1][n-1]): return self.dp_grid[m-1][n-1]

        self.dp_grid[m-1][n-1] = self.path(m-1, n) + self.path(m, n-1)

        return self.dp_grid[m-1][n-1]

    def get2dArray(self, rows, cols):
        return [[0 for i in range(cols)] for j in range(rows)]

a_solution = Solution()
result = a_solution.uniquePaths(99, 24)
print(result)