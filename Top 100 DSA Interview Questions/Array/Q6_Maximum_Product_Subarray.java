public class Q6_Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        // Optimized Approach (Kadane's Style)
        // Time : o(n) , space:O(1)

        int currentMax = nums[0];
        int currentMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            result = Math.max(result, currentMax);
        }

        return result;
    }

}
