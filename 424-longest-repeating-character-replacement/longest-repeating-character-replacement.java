class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Frequency array for 'A' to 'Z'
        int left = 0, right = 0;
        int maxCount = 0; // To keep track of maximum frequency of a single character
        int maxLength = 0; // To store maximum length found

        while (right < s.length()) {
            // Update count for current character
            count[s.charAt(right) - 'A']++;
            // Update maxCount
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // Check if we need to shrink our window
            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--; // Reduce count for leftmost character
                left++; // Move left pointer to shrink window
            }

            // Update maxLength with current valid window size
            maxLength = Math.max(maxLength, right - left + 1);
            right++; // Move right pointer to expand window
        }

        return maxLength;
    }
}