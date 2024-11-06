class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         // HashMap to store grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            
            // Convert sorted character array back to string
            String sortedString = new String(charArray);

            // If the sorted string is not in the map, add it with a new list
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            
            // Add the original string to the list corresponding to the sorted string
            map.get(sortedString).add(s);
        }

        // Return the values of the map as a result
        return new ArrayList<>(map.values());
    }
}