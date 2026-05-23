class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // Plus operator
            else if (ch == '+') {
                result += sign * number;

                number = 0;
                sign = 1;
            }

            // Minus operator
            else if (ch == '-') {
                result += sign * number;

                number = 0;
                sign = -1;
            }

            // Open parenthesis
            else if (ch == '(') {

                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                // Reset for new expression
                result = 0;
                sign = 1;
            }

            // Close parenthesis
            else if (ch == ')') {

                // Finish current number
                result += sign * number;

                number = 0;

                // First pop sign
                int prevSign = stack.pop();

                // Then previous result
                int prevResult = stack.pop();

                // Merge expression
                result = prevResult + prevSign * result;
            }
        }

        // Add last pending number
        result += sign * number;

        return result;
    }
}