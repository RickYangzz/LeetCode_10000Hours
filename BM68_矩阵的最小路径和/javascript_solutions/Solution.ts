/**
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * 
 * @param matrix int整型二维数组 the matrix
 * @return int整型
 */
export function minPathSum(matrix: number[][]): number {
    if(matrix.length == 0 || matrix[0].length == 0) return 0;

    const m = matrix.length;
    const n = matrix[0].length;
    const dp = Array.from({length: m}, () => new Array(n).fill(0));

    dp[0][0] = matrix[0][0];

    for (let i = 1; i < m; i++) {
        dp[i][0] = dp[i-1][0] + matrix[i][0];
    }

    for (let j = 1; j < n; j++) {
        dp[0][j] = dp[0][j-1] + matrix[0][j];
    }

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
        }
    }

    return dp[m-1][n-1];
}
