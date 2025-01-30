package BM61_矩阵最长递增路径.java_solutions;

public class DfsSolution {
    private int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int n = 0;
    private int m = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 递增路径的最大长度
     * 
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int res = 0;
        this.n = matrix.length;
        this.m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j]++;

        for (int k = 0; k < 4; k++) {
            int nexti = i + direction[k][0];
            int nextj = j + direction[k][1];

            if (nexti >= 0 &&
                    nexti < this.n &&
                    nextj >= 0 &&
                    nextj < this.m &&
                    matrix[nexti][nextj] > matrix[i][j]) {
                        
                dp[i][j] = Math.max(dp[i][j], this.dfs(matrix, dp, nexti, nextj) + 1);
            }
        }

        return dp[i][j];
    }
}