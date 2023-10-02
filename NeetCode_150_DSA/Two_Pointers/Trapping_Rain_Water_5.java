package NeetCode_150_DSA.Two_Pointers;

public class Trapping_Rain_Water_5 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {

        // Brute Force (Not TLE but Take LOT TIME)

        /*
         * int n = height.length;
         * int trappedWater = 0;
         * 
         * for (int i = 1; i < n - 1; i++) {
         * int leftMax = 0;
         * int rightMax = 0;
         * 
         * // Find the maximum height to the left
         * for (int j = i; j >= 0; j--) {
         * leftMax = Math.max(leftMax, height[j]);
         * }
         * 
         * // Find the maximum height to the right
         * for (int j = i; j < n; j++) {
         * rightMax = Math.max(rightMax, height[j]);
         * }
         * 
         * // Calculate the trapped water at the current index
         * trappedWater += Math.min(leftMax, rightMax) - height[i];
         * }
         * 
         * return trappedWater;
         */

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}
