package NeetCode_150_DSA.Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum_3 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // Extreme Brute Force Solution (Time: O(n^3), Space: O(1))
        // Got TLE
     
        // List<List<Integer>> result = new ArrayList<>();

        // if (nums == null || nums.length < 3) {
        //     return result;
        // }

        // int n = nums.length;

        // for (int i = 0; i < n - 2; i++) {
        //     for (int j = i + 1; j < n - 1; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 triplet.sort(null);
        //                 if (!result.contains(triplet)) {
        //                     result.add(triplet);
        //                 }
        //             }
        //         }
        //     }
        // }

        // return result;

        // Optimized Solution (Time: O(n^2), Space: O(1))
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // Skip duplicates
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // Skip duplicates
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;

    }
}
