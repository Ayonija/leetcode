class Solution {
    public boolean canJump(int[] nums) {
         int maxReach = 0; // This keeps track of the farthest index we can reach
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If we are at an index that is beyond the maximum reachable index
            if (i > maxReach) {
                return false; // Cannot reach this index
            }
            // Update the maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can reach or exceed the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }
        
        return false; // If we finish the loop and haven't reached the last index
    }
}