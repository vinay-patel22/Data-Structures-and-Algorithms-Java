package NeetCode_150_DSA.Two_Pointers;

public class Two_Sum_II_Input_Array_Is_Sorted_2 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        // Brute Force
        // Time:- O(n^2) Space:-O(1)

        // int[] ans = new int[2];
        // for (int i = 0; i < numbers.length; i++) {
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             ans[0] = i + 1;
        //             ans[1] = j + 1;
        //             return ans;
        //         }
        //     }
        // }
        // return ans;

        // Two-Pointer Approach
        int[] ans = new int[2];
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return ans; // Not Found
    }
}
