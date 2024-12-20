public class Q7_Find_Minimum_in__Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        // time : O(n) , space:O(1)

        // int min = Integer.MAX_VALUE;

        // for (int num : nums) {
        // if (num < min) {
        // min = num;
        // }
        // }
        // return min;

        // ! Modified Binary Search
        // time : O(log n ) , space:O(1)

        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

}
