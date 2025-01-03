class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> charCountT = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
        }

        int required = charCountT.size();
        int formed = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (charCountT.containsKey(c) && windowCounts.get(c).intValue() == charCountT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                // Update minimum length and starting index
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Try to shrink the window
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (charCountT.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < charCountT.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}