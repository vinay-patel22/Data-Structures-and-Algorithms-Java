public class Q12_Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        // 1. Brute Force Approach -> time : O(n^2) space:O(1)
        // Surely got TLE in large cases

        // int n = height.length;
        // int totalWater = 0;

        // for (int i = 0; i < n; i++) {
        // int leftMax = 0, rightMax = 0;

        // // Find the maximum height on the left
        // for (int j = 0; j <= i; j++) {
        // leftMax = Math.max(leftMax, height[j]);
        // }

        // // Find the maximum height on the right
        // for (int j = i; j < n; j++) {
        // rightMax = Math.max(rightMax, height[j]);
        // }

        // // Calculate trapped water at current position
        // totalWater += Math.min(leftMax, rightMax) - height[i];
        // }

        // return totalWater;

        // ? Dynamic Programming Approach
        // Time : O(n) , space: O(n)

        // int n = height.length;
        // if (n == 0)
        // return 0;

        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // int totalWater = 0;

        // // Precompute left max
        // leftMax[0] = height[0];
        // for (int i = 1; i < n; i++) {
        // leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        // }

        // // Precompute right max
        // rightMax[n - 1] = height[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        // rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        // }

        // // Calculate trapped water
        // for (int i = 0; i < n; i++) {
        // totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        // }

        // return totalWater;

        // ! Two-Pointer Approach
        // Time :O(n) , space:O(1)

        int n = height.length;
        if (n == 0)
            return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;

    }

}