import java.util.Arrays;

public class Q4_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // 1. Brute Force Approach (Time : O(n^2) space:O(1))
        // int n = nums.length;
        // int[] result = new int[n];

        // for (int i = 0; i < n; i++) {
        // int product = 1;
        // for (int j = 0; j < n; j++) {
        // if (i != j) {
        // product *= nums[j];
        // }
        // }
        // result[i] = product;
        // }

        // return result;

        // 2. Better Approach (Using Division)
        // Time : O(n) , space: O(1)
        // ? division used : yes

        // int n = nums.length;
        // int[] result = new int[n];
        // int totalProduct = 1;
        // int zeroCount = 0;

        // // Calculate total product and count zeros
        // for (int num : nums) {
        // if (num == 0) {
        // zeroCount++;
        // } else {
        // totalProduct *= num;
        // }
        // }

        // // If more than one zero, all products are zero
        // if (zeroCount > 1) {
        // return result; // all values will be 0 by default
        // }

        // for (int i = 0; i < n; i++) {
        // if (nums[i] == 0) {
        // result[i] = totalProduct; // For the zero element, result is the total
        // product
        // } else if (zeroCount == 1) {
        // result[i] = 0; // If there's one zero, non-zero elements contribute 0
        // } else {
        // result[i] = totalProduct / nums[i];
        // }
        // }

        // return result;

        // Method 3: Optimized Approach (Prefix and Suffix Products Without Division)
        // Time : O(n) , space: O(1) extra space (excluding the output array).
        // ? division used : no
        // ? This satisfies the requirement of avoiding the division operation

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix product
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct; // Store prefix product for current index
            prefixProduct *= nums[i]; // Update prefix product
        }

        // Step 2: Calculate suffix product and combine with prefix
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct; // Combine prefix and suffix products
            suffixProduct *= nums[i]; // Update suffix product
        }

        return result;

    }

}