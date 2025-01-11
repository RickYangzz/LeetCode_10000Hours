/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 判断岛屿数量
 * @param grid char字符型二维数组 
 * @return int整型
 */
export function solve(grid: string[][]): number {
    let result = 0

    if (grid.length == 0 || grid[0].length == 0) return result;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] != '1') continue;

            result++;

            bfs(grid, i, j);
        }
    }

    return result;
}

function bfs(grid: string[][], row: number, col: number): void {
    const queue = [[row, col]];
    grid[row][col] = '0';

    while (queue.length > 0) {
        const position = queue.shift();
        if(!position) throw new Error("煞笔ts, 非得让我写这行代码。");
        
        const [i, j] = position;

        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            grid[i][j-1] = '0';
            queue.push([i, j-1]);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            grid[i-1][j] = '0';
            queue.push([i - 1, j]);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            grid[i][j+1] = '0';
            queue.push([i, j + 1]);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            grid[i+1][j] = '0';
            queue.push([i + 1, j]);
        }
    }
}