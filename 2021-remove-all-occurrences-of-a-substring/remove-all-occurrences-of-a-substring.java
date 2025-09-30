class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");  // remove leftmost occurrence
        }
        return s;
    }
}