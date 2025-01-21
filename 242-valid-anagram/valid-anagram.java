class Solution {
    public boolean isAnagram(String s, String t) {
       /*
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            if(dict.containsKey(c)){
                dict.put(c,dict.get(c)+1);
            }   else {
                dict.put(c,1);
            }
        }
        int charNotFoundCount = 0;
        for(char d: t.toCharArray()) {
            if(dict.containsKey(d)) {
                dict.put(d,dict.get(d)-1);
                if(dict.get(d)<=0) {
                    dict.remove(d);
                }
            }
            else {
                charNotFoundCount++;
            }
        }
        if(charNotFoundCount>0 || !dict.isEmpty()){
            return false;
        }
        else
            return true; */


        // If lengths are not the same, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert strings to character arrays and sort them
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        
        // Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }
}