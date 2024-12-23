import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q14_Merge_Intervals {
    public static void main(String[] args) {
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(merge(intervals1)));
    }
    // 1. Brute Force Approach
    // This approach checks for overlapping intervals by comparing each interval
    // with all others. It's less efficient and has a time complexity of O(n^2).

    // Time Complexity: O(n^2)
    // Space Complexity: O(n) (for storing results)

    // public static int[][] merge(int[][] intervals) {
    // List<int[]> result = new ArrayList<>();

    // for (int i = 0; i < intervals.length; i++) {
    // boolean merged = false;
    // for (int j = 0; j < intervals.length; j++) {
    // if (i != j && isOverlap(intervals[i], intervals[j])) {
    // result.add(mergeIntervals(intervals[i], intervals[j]));
    // merged = true;
    // break;
    // }
    // }
    // if (!merged) {
    // result.add(intervals[i]);
    // }
    // }

    // return result.toArray(new int[result.size()][]);
    // }

    // private static boolean isOverlap(int[] a, int[] b) {
    // return !(a[1] < b[0] || b[1] < a[0]);
    // }

    // private static int[] mergeIntervals(int[] a, int[] b) {
    // return new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
    // }

    // 2. Optimized Approach (Sorting)
    // Sort the intervals based on the start times and then merge them one by one.
    // This is a more efficient approach and works in O(n log n) due to sorting.

    // Time Complexity: O(n log n)
    // Space Complexity: O(n) (for sorting and storing the results)

    // public static int[][] merge(int[][] intervals) {
    // if (intervals.length == 0)
    // return new int[0][0];

    // // Sort intervals by start time
    // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // List<int[]> result = new ArrayList<>();
    // result.add(intervals[0]);

    // for (int i = 1; i < intervals.length; i++) {
    // int[] last = result.get(result.size() - 1);
    // int[] current = intervals[i];

    // // If current interval overlaps with last, merge them
    // if (current[0] <= last[1]) {
    // last[1] = Math.max(last[1], current[1]);
    // } else {
    // result.add(current);
    // }
    // }

    // return result.toArray(new int[result.size()][]);
    // }

    // 3. Optimized Approach (In-place Sorting and Merging)
    // Instead of using a list to store merged intervals, we can modify the input
    // array directly after sorting. This reduces space complexity but still
    // achieves O(n log n) time complexity.

    // Time Complexity: O(n log n)
    // Space Complexity: O(1) (in-place modification of intervals)

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int index = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                // Merge intervals
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        // Copy the result to a new array
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }

}
