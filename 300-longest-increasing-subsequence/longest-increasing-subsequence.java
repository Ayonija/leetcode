class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        // Array to store the smallest tail for increasing subsequences
        int[] tails = new int[nums.length];
        int size = 0; // Length of the current longest increasing subsequence

        for (int num : nums) {
            // Use binary search to find the insertion point
            int left = 0;
            int right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1; // Look for a larger tail
                } else {
                    right = mid; // Look for a smaller or equal tail
                }
            }

            // Update or extend the tails array
            tails[left] = num;
            if (left == size) {
                size++; // Increase size if we are adding a new largest element
            }
        }

        return size;
    }
}