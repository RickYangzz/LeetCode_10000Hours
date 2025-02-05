/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param m int整型 
 * @param n int整型 
 * @return int整型
 */
export function uniquePaths(m: number, n: number): number {
    const dp = Array.from({length: m+1}, ()=> new Array(n+1).fill(1));
    for (let i = 2; i <= m; i++) {
        for (let j = 2; j <= n; j++) {
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    return dp[m][n];
}
