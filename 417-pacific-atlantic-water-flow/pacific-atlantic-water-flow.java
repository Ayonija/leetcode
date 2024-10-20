class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Perform DFS from Pacific Ocean (top and left edges)
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, cols - 1);
        }
        // Perform DFS from Atlantic Ocean (bottom and right edges)
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, rows - 1, j);
        }

        // Collect results where both oceans can be reached
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        // Directions for moving up, down, left, or right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Check bounds and height condition
            if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length &&
                !visited[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                
                dfs(heights, visited, newX, newY); // Recursive call
            }
        }
    }
}