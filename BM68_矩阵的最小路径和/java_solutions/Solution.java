package BM68_矩阵的最小路径和.java_solutions;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = matrix[0][0];
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}