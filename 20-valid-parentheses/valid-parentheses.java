class Solution {
    public boolean isValid(String s) {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If it's a closing bracket
            else {
                // Check if the stack is empty or if it doesn't match the top of the stack
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were matched; otherwise, it's invalid
        return stack.isEmpty();
    }
    // Helper method to check if the pair of brackets match
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}