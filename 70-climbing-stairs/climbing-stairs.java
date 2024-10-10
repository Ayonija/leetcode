class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0; // No steps
        if (n == 1) return 1; // Only one way to climb one step
        if (n == 2) return 2; // Two ways to climb two steps

        int[] dp = new int[n + 1];
        dp[1] = 1; // One way to climb one step
        dp[2] = 2; // Two ways to climb two steps

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Fill the dp array based on previous two values
        }

        return dp[n];
    }
}