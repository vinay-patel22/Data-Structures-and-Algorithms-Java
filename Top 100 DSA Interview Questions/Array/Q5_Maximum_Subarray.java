//! Kadane's Algorithm

public class Q5_Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        // brute force
        // time : o(n^2) , space: O(1)
        // TLE in leetcode

        // int n = nums.length;
        // int maxSum = Integer.MIN_VALUE;

        // for (int i = 0; i < n; i++) {
        // int currentSum = 0;
        // for (int j = i; j < n; j++) {
        // currentSum += nums[j];
        // maxSum = Math.max(maxSum, currentSum);
        // }
        // }

        // return maxSum;

        // better
        // time:O(n^2) , spce : O(n)
        // Also get TLE

        // int n = nums.length;
        // int[] prefixSum = new int[n + 1];
        // prefixSum[0] = 0;

        // for (int i = 0; i < n; i++) {
        // prefixSum[i + 1] = prefixSum[i] + nums[i];
        // }

        // int maxSum = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < n; j++) {
        // int subArraySum = prefixSum[j + 1] - prefixSum[i];
        // maxSum = Math.max(maxSum, subArraySum);
        // }
        // }

        // return maxSum;

        // ! Optimized Approach (Kadane's Algorithm)

        int maxSum = nums[0]; // Global max
        int currentSum = nums[0]; // Max subarray sum ending at current index

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // Extend or start new subarray
            maxSum = Math.max(maxSum, currentSum); // Update global max
        }

        return maxSum;

    }

}
