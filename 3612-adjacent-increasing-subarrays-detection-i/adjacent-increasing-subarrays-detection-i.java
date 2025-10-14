class Solution {
public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        // Helper function to check if subarray [start, start + k - 1] is strictly increasing
        for (int a = 0; a + 2 * k <= n; a++) {
            if (isIncreasing(nums, a, k) && isIncreasing(nums, a + k, k)) {
                return true;
            }
        }

        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start + 1; i < start + k; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}