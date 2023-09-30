package Arrays_And_Hashing;

import java.util.HashSet;

public class Longest_Consecutive_Sequence_9 {
    public static void main(String[] args) {
        Longest_Consecutive_Sequence_9 solution = new Longest_Consecutive_Sequence_9();

        // Example 1:
        int[] nums1 = { 100, 4, 200, 1, 3, 2 };
        int result1 = solution.longestConsecutive(nums1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2:
        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        int result2 = solution.longestConsecutive(nums2);
        System.out.println("Example 2 Output: " + result2);
    }

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // If the current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentLength = 1;
                while (numSet.contains(num + 1)) {
                    num++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;

        // Below Is Using Hash Map

        /*
         * if (nums.length == 0)
         * return 0;
         * HashSet<Integer> hs = new HashSet<>();
         * for (int num : nums)
         * hs.add(num);
         * int longest = 1;
         * for (int num : nums) {
         * // check if the num is the start of a sequence by checking if left exists
         * if (!hs.contains(num - 1)) { // start of a sequence
         * int count = 1;
         * while (hs.contains(num + 1)) { // check if hs contains next no.
         * num++;
         * count++;
         * }
         * longest = Math.max(longest, count);
         * 
         * }
         * if (longest > nums.length / 2)
         * break;
         * 
         * }
         * return longest;
         * 
         */
    }
}
