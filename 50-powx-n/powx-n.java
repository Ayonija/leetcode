class Solution {
    public static double myPow(double x, int n) {
        // Handle the case when n is negative
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        return powHelper(x, n);
    }

    private static double powHelper(double x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        
        // Recursive case
        double half = powHelper(x, n / 2);
        
        if (n % 2 == 0) { // If n is even
            return half * half;
        } else { // If n is odd
            return half * half * x;
        }
    }
}