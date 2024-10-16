class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged is empty or there is no overlap, add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // There is an overlap, so merge the current interval with the last one in merged
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert List<int[]> back to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}