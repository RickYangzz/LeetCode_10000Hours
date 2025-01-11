/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 判断岛屿数量
 * @param grid char字符型二维数组 
 * @return int整型
 */
export function solve(grid: string[][]): number {
    let result = 0

    if(grid.length == 0 || grid[0].length == 0) return result;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if(grid[i][j] != '1') continue;

            result++;

            dfs(grid, i, j);
        }
    }

    return result;
}

function dfs(grid: string[][], i: number, j: number): void{
    grid[i][j] = '0';

    if(j-1 >= 0 && grid[i][j-1] == '1') dfs(grid, i, j-1);
    if(i-1 >= 0 && grid[i-1][j] == '1') dfs(grid, i-1, j);
    if(j+1 < grid[i].length && grid[i][j+1] == '1') dfs(grid, i, j+1);
    if(i+1 < grid.length && grid[i+1][j] == '1') dfs(grid, i+1, j);
}