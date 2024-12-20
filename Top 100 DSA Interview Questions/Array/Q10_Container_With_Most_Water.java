public class Q10_Container_With_Most_Water {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        // brute force : O(n^2) : TLE
        // int maxWater = 0; // ans

        // for (int i = 0; i < height.length - 1; i++) { // Left Boundiray
        // for (int j = i + 1; j < height.length; j++) { // right boundiray
        // int width = j - i;
        // int ht = Math.min(height[i], height[j]);
        // int currentWater = width * ht;
        // maxWater = Math.max(maxWater, currentWater);
        // }
        // }

        // return maxWater;

        // ! Two Pointer Approach
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
