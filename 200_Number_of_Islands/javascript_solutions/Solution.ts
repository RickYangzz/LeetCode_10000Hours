function numIslands(grid: string[][]): number {
    if(grid.length == 0 || grid[0].length == 0) return 0;

    let result = 0;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if(grid[i][j] == '1'){
                result += 1;
                dfs(grid, i, j);
            }
        }
    }

    return result;
};

function dfs(grid, i, j){
    if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]!='1'){
        return;
    }

    grid[i][j] = '0';

    dfs(grid, i-1, j);
    dfs(grid, i+1, j);
    dfs(grid, i, j-1);
    dfs(grid, i, j+1);
}