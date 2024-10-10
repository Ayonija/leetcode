class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Create a set from the word dictionary for efficient look-up
        Set<String> wordSet = new HashSet<>(wordDict);
        int strLength = s.length();
        
        // Initialize a boolean array to keep track of possible word breaks
        boolean[] dp = new boolean[strLength + 1];
        dp[0] = true; // An empty string can always be segmented

        // Iterate over the length of the string
        for (int i = 1; i <= strLength; i++) {
            // Check every substring ending at index i
            for (int j = 0; j < i; j++) {
                // If the substring s[j:i] is in the dictionary and s[0:j] can be segmented
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid segmentation
                }
            }
        }
        return dp[strLength]; // Return whether the entire string can be segmented
    }
}