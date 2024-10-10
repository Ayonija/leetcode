class Solution {
    public int combinationSum4(int[] nums, int target) {
         // Create a memoization array to store results for subproblems
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to reach zero (using no elements)

        // Iterate through each possible sum from 1 to target
        for (int i = 1; i <= target; i++) {
            // For each number in nums, check if it can contribute to the current sum i
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num]; // Add ways to form (i - num) to ways to form i
                }
            }
        }

        return dp[target]; // The number of combinations that sum up to target
    }
}