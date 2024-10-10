class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int strLength = s.length();
        
        // Initialize a boolean array to keep track of possible word breaks
        boolean[] dp = new boolean[strLength + 1];
        dp[0] = true; // An empty string can always be segmented

        // Iterate over the length of the string
        for (int i = 1; i <= strLength; i++) {
            // Check every substring ending at index i
            for (int j = Math.max(0, i - 20); j < i; j++) { // Limit j to the last 20 characters
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid segmentation
                }
            }
        }
         return dp[strLength]; // Return whether the entire string can be segmented
    }
}