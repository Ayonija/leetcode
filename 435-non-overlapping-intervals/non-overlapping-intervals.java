class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         // If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Initialize variables
        int removedIntervalsCount = 0;
        int endTime = intervals[0][1];

        // Iterate through the sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            // If there is an overlap
            if (intervals[i][0] < endTime) {
                removedIntervalsCount++; // Increment removal count
            } else {
                endTime = intervals[i][1]; // Update end time
            }
        }

        return removedIntervalsCount;
    }
}