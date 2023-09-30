package Arrays_And_Hashing;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum_3 {
    public static void main(String[] args) {
        Two_Sum_3 solution = new Two_Sum_3();

        // Input
        int[] nums = { 3,2,4 };
        int target = 6;

        // Find the indices of two numbers that add up to the target
        int[] result = solution.twoSum(nums, target);

        // Output
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("], target = " + target);

        if (result != null) {
            System.out.println("Output: [" + result[0] + "," + result[1] + "]");
        } else {
            System.out.println("Output: No solution found.");
        }
    }

    public int[] twoSum(int[] nums, int target) {

        // Brute Force

        // for(int i =0;i<nums.length;i++){
        // for(int j=i+1;j<nums.length;j++){
        // if(nums[j]==target-nums[i]){
        // return new int []{i,j};
        // }
        // }
        // }
        // return null;

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[] { indexMap.get(complement), i };
            }

            indexMap.put(nums[i], i);
        }

        return null;
    }
}
