class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];

        // Iterate through each character in text1
        for (int i = 1; i <= m; i++) {
            int prev = 0; // To store the value of dp[i-1][j-1]
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Store current dp[j] value
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1; // Update dp[j] if characters match
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]); // Take max from left or above
                }
                prev = temp; // Update prev for next iteration
            }
        }

        return dp[n]; // Length of the longest common subsequence
    }
}