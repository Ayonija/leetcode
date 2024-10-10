class Solution {
    public int hammingWeight(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int originalN = n;

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        
        cache.put(originalN, count); // Cache the result
        return count;
    }
}