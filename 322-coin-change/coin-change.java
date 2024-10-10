class Solution {
    public int coinChange(int[] coins, int amount) {
         // Initialize dp array
        int[] dp = new int[amount + 1];
        
        // Set all values to a large number (amount + 1)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; 
        }
        
        // Base case: 0 coins are needed to make the amount of 0
        dp[0] = 0;

        // Fill the dp array
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        // Check if we were able to form the desired amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}