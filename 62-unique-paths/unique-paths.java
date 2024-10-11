class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths
        int[][] dp = new int[m][n];
        
        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // Only one way to reach any cell in the first column
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // Only one way to reach any cell in the first row
        }

        // Fill in the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // Sum paths from above and left
            }
        }

        // The bottom-right corner contains the total number of unique paths
        return dp[m-1][n-1];
    }
}