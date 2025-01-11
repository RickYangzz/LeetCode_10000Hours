package BM57_岛屿数量.java_solutions;

public class DfsSolution {
    /**
     * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
     *
     * 
     * @param grid char字符型二维数组 
     * @return int整型
     */
    public int solve (char[][] grid) {
        int result = 0;

        if (grid.length == 0 || grid[0].length == 0) return result;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '1') continue;
                result++;
                dfs(grid, i, j);
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j){
        if(grid[i][j] == '1') grid[i][j] = '0';

        // left
        if(j-1 >= 0 && grid[i][j-1] == '1') dfs(grid, i, j-1);
        // up
        if(i-1 >= 0 && grid[i-1][j] == '1') dfs(grid, i-1, j);
        // right
        if(j+1 < grid[i].length && grid[i][j+1] == '1') dfs(grid, i, j+1);
        // down
        if(i+1 < grid.length && grid[i+1][j] == '1') dfs(grid, i+1, j);
    }
}