class Solution {
    public int trapRainWater(int[][] heightMap) {
         if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min heap to store boundary cells (height, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        // Step 1: Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: Process cells from lowest boundary
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0];
            int row = cell[1];
            int col = cell[2];

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol])
                    continue;

                visited[newRow][newCol] = true;

                // If neighbor is lower, water can be trapped
                int neighborHeight = heightMap[newRow][newCol];
                if (neighborHeight < height) {
                    totalWater += height - neighborHeight;
                }

                // Push the max height as the new boundary
                pq.offer(new int[]{Math.max(height, neighborHeight), newRow, newCol});
            }
        }

        return totalWater;
    }
}