package Arrays_And_Hashing;

public class Product_of_Array_Except_Self_6 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {

        // Brute Force Give TLE :)

        // int[] result = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     // int temp = nums[i];
        //     int temp = 1;
        //     for (int j = 0; j < nums.length; j++) {
        //         // int ans = temp*nums[j];
        //         // return new int[]{ans};
        //         if (i != j) {
        //             temp *= nums[j];
        //         }
        //     }
        //     result[i] = temp;
        // }
        // // return null;
        // return result;

        int n = nums.length;
        int[] result = new int[n];

        // int prefixProduct = 1;
        int Prefixtemp = 1;
        for (int i = 0; i < n; i++) {
            result[i] = Prefixtemp;
            Prefixtemp *= nums[i];
        }
        int Suffixtemp = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= Suffixtemp;
            Suffixtemp *= nums[i];
        }
        return result;
    }
}
