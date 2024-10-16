class Solution {
    public int numIslands(char[][] grid) {
       if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // When we find a '1', we have found an island
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Perform DFS to mark all parts of this island
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands; 
    }

    private void dfs(char[][] grid, int i, int j) {
        // Check bounds and if the current cell is water
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited by turning it into water
        grid[i][j] = '0';

        // Explore all adjacent cells (up, down, left, right)
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }

}