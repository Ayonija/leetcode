class Solution {
    public int numPairsDivisibleBy60(int[] time) {
                int[] freq = new int[60];

        int count = 0;

        for (int t : time) {

            int remainder = t % 60;

            // Find required complement
            int complement = (60 - remainder) % 60;

            // Add previously seen complements
            count += freq[complement];

            // Store current remainder
            freq[remainder]++;
        }

        return count;
    }
}