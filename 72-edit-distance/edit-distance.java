class Solution {
    public int minDistance(String word1, String word2) {
        // Handle edge cases
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        // Create DP table with optimized space
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        
        // Initialize first row
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;
            
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(prev,  // Replace
                                Math.min(dp[j],  // Delete
                                       dp[j-1])); // Insert
                }
                prev = temp;
            }
        }
        
        return dp[n];
    }
}