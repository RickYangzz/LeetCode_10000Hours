import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0)
            return 0;

        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges += 1;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        if(freshOranges == 0) return 0;
        if(queue.isEmpty()) return -1;

        int minutes = -1;
        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0) {
                int[] rotten = queue.poll();
                int x = rotten[0];
                int y = rotten[1];
                for (int[] direction : dirs) {
                    int i = x + direction[0];
                    int j = y + direction[1];
                    if(i>=0 && j>=0 && i<m && j<n && grid[i][j] == 1){
                        grid[i][j] = 2;
                        freshOranges--;
                        queue.offer(new int[]{i,j});
                    }
                }
            }
            minutes += 1;
        }

        if(freshOranges > 0) return -1;
        return minutes;
    }
}