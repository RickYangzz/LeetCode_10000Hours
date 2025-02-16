function orangesRotting(grid: number[][]): number {
    const m = grid.length;
    const n = grid[0].length;
    if(m == 0 || n == 0) return 0;

    let freshOranges = 0;
    const rottrenQueue: number[][] = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if(grid[i][j] == 1){
                freshOranges += 1;
            }else if(grid[i][j] == 2){
                rottrenQueue.push([i,j]);
            }
        }
    }

    if(freshOranges == 0) return 0;
    if(rottrenQueue.length == 0) return -1;

    let minutes = -1;
    const directions = [[1,0],[-1,0],[0,-1],[0,1]];
    while(rottrenQueue.length > 0){
        let size = rottrenQueue.length;
        while(size > 0){
            size--;

            const rottenOrange = rottrenQueue.shift();
            if(rottenOrange == undefined) throw new Error('Data error: rottrenQueue');
            const _i = rottenOrange[0];
            const _j = rottenOrange[1];
            for (const dir of directions) {
                const i = _i + dir[0];
                const j = _j + dir[1];
                if(i>=0 && j>=0 && i<m && j<n && grid[i][j] == 1){
                    grid[i][j] = 2;
                    freshOranges -= 1;
                    rottrenQueue.push([i,j]);
                }
            }
        }
        minutes += 1;
    }

    if(freshOranges > 0) return -1;
    return minutes;
};