import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q13_Insert_Interval {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] result = insert(intervals, newInterval);

        // Print the result
        System.out.println("Merged intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

    }

    // Time :- o(n);
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                result.add(in);
            } else if (newInterval[1] < in[0]) {
                result.add(newInterval);
                newInterval = in;
            } else { // case for overlapping
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }
        }

        result.add(newInterval);
        return result.toArray(new int[result.size()][]);

    }
}