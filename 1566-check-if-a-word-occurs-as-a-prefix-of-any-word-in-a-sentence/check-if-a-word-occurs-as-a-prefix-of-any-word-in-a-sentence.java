class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = 0;
        if (sentence.isEmpty())
            return -1;
        
        String[] wordInSentence = sentence.split(" ");

        for(String s : wordInSentence) {
            index++;
            if(s.indexOf(searchWord) == 0){
                return index;
            }
        }
        return -1;
    }
}