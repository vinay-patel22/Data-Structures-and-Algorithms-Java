import java.util.Arrays;

public class Q15_Non_overlapping_Intervals {

    public static void main(String[] args) {
        int[][] intervals1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals1));

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // Time : O(nlogn) , space:O(1)
        if (intervals.length == 0)
            return 0;

        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        // Start from the second interval and check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts before the previous one ends, it overlaps
            if (intervals[i][0] < end) {
                count++; // We need to remove this interval
            } else {
                // Update the end time to the current interval's end time
                end = intervals[i][1];
            }
        }

        return count;

    }
}