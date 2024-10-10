class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // Maximum amount robbed up to house i-2
        int prev1 = nums[0]; // Maximum amount robbed up to house i-1

        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]); // Max of robbing this house or not
            prev2 = prev1; // Move forward in the array
            prev1 = current; // Update for next iteration
        }

        return prev1; // The maximum amount that can be robbed
    }
}