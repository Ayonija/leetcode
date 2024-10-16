class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in the set
        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the streak
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}