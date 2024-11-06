class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        
        // Check if the target is achievable
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        
        // Calculate the new target for the subset sum problem
        int newTarget = (sum - target) / 2;
        int[] dp = new int[newTarget + 1];
        
        // Base case: there's one way to make the sum 0 (by choosing no elements)
        dp[0] = 1;

        // Fill the dp array
        for (int num : nums) {
            for (int j = newTarget; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[newTarget];
    }
}