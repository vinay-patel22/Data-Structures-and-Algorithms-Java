// Amazon Question

// Tips1 :-  range [1, n] then index = value -1
// Tips2 :-  range [0, n] then index = value 

//! Optimal Approach using Floyd’s Tortoise and Hare (O(n) time, O(1) space)

public class Q3_Find_duplicates {
    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 3, 3 };
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        // Method 1

        // int i = 0;
        // while (i < nums.length) {

        // if (nums[i] != i + 1) {
        // int correct = nums[i] - 1; // Tips1
        // if (nums[i] != nums[correct]) {

        // // Swap
        // int temp = nums[i];
        // nums[i] = nums[correct];
        // nums[correct] = temp;
        // } else {
        // return nums[i];
        // }
        // } else {
        // i++;
        // }
        // }

        // return -1;

        // ! Floyd’s Tortoise and Hare (O(n) time, O(1) space)

        // Step 1: Detect the cycle using two pointers (Floyd's Tortoise and Hare)

        int slow = nums[0];
        int fast = nums[0];

        // Move slow by one and fast by two until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find the entry point of the cycle (duplicate number)
        slow = nums[0]; // Reset slow to the start
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // This is duplicate number
    }
}
