class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder output = new StringBuilder();
        int initial=0;
        int later;
        for(int i=0;i<spaces.length;i++){
            later = spaces[i];
            String part = s.substring(initial, later);
            initial = later;
            output.append(part);
            output.append(" ");
        }
        output.append(s.substring(initial,s.length()));
        return output.toString();
    }
}