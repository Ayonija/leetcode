class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int leftPointer = 0; // Left boundary of the sliding window

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char currentChar = s.charAt(rightPointer);

            // If the character is already in the map, move the left pointer
            if (charIndexMap.containsKey(currentChar)) {
                // Update leftPointer to be one position after the last occurrence
                leftPointer = Math.max(charIndexMap.get(currentChar) + 1, leftPointer);
            }

            // Update or add the character's index in the map
            charIndexMap.put(currentChar, rightPointer);
            // Calculate the maximum length of substring found so far
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
        }

        return maxLength;
     }
}