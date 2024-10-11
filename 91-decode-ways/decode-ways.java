class Solution {
    public int numDecodings(String s) {
       if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case for empty string
        
        // Check if the first character is valid
        dp[1] = (s.charAt(0) != '0') ? 1 : 0; 
        
        for (int i = 2; i <= n; i++) {
            // Single digit decode
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Two digit decode
            String twoDigit = s.substring(i - 2, i);
            if (twoDigit.compareTo("10") >= 0 && twoDigit.compareTo("26") <= 0) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n]; 
    }
}