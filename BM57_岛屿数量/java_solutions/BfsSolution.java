package BM57_岛屿数量.java_solutions;

import java.util.ArrayDeque;

public class BfsSolution {
    public int solve (char[][] grid) {
        int result = 0;

        if(grid.length == 0 || grid[0].length == 0) return result;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != '1') continue;

                result++;
                bfs(grid, i, j);
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int row, int col){

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        grid[row][col] = '0';
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int i = position[0];
            int j = position[1];
    
            // left
            if(j-1 >= 0 && grid[i][j-1] == '1') {
                grid[i][j-1] = '0';
                queue.offer(new int[] {i, j-1});
            }
            // up
            if(i-1 >= 0 && grid[i-1][j] == '1') {
                grid[i-1][j] = '0';
                queue.offer(new int[] {i-1, j});
            }
            // right
            if(j+1 < grid[i].length && grid[i][j+1] == '1'){
                grid[i][j+1] = '0';
                queue.offer(new int[] {i, j+1});
            }
            // down
            if(i+1 < grid.length && grid[i+1][j] == '1') {
                grid[i+1][j] = '0';
                queue.offer(new int[] {i+1, j});
            }
        }
    }
}
