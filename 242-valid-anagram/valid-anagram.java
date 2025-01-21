class Solution {
    public boolean isAnagram(String s, String t) {
       
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
            return true;
    }
}