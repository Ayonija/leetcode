class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> last day it was filled
        TreeSet<Integer> dryDays = new TreeSet<>();        // indices where rains[i] == 0

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // default (may change later)
            } else {
                ans[i] = -1; // raining day
                int lake = rains[i];

                // Check if lake already full
                if (fullLakes.containsKey(lake)) {
                    // Find next dry day after it was last filled
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // no dry day available -> flood
                    }
                    ans[dryDay] = lake; // dry this lake
                    dryDays.remove(dryDay);
                }

                // Update that this lake is now full
                fullLakes.put(lake, i);
            }
        }
        return ans;
        
    }
}