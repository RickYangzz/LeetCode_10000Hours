let n = 0;
let m = 0;
const direction = [[-1, 0],[1, 0],[0, -1],[0, 1]];

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 递增路径的最大长度
 * @param matrix int整型二维数组 描述矩阵的每个数
 * @return int整型
 */
export function solve(matrix: number[][]): number {
    if(matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }

    n = matrix.length;
    m = matrix[0].length;

    const dp = Array.from({length: n}, () => new Array(m).fill(0));

    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            res = Math.max(res, dfs(matrix, dp, i, j));
        }
    }

    return res;
}

function dfs(matrix: number[][], dp: number[][], i: number, j:number): number{
    if(dp[i][j] != 0){
        return dp[i][j];
    }

    dp[i][j]++;
    
    for(let k = 0; k < 4; k++){
        const nexti = i + direction[k][0];
        const nextj = j + direction[k][1];

        if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && matrix[nexti][nextj] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, dp, nexti, nextj) + 1);
        }
    }

    return dp[i][j];
}
