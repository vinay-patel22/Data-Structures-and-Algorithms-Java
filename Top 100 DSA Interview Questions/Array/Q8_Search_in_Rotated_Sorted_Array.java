public class Q8_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        // brute force : time-O(n) , space:O(1)

        // for(int i=0;i<nums.length;i++){
        // if(nums[i]==target){
        // return i;
        // }
        // }
        // return -1;

        // ! Better Approach (Binary Search with Rotation Handling)
        // time : O(log n) , space:O(1)

        // int left = 0, right = nums.length - 1;

        // while (left <= right) {
        // int mid = left + (right - left) / 2;

        // if (nums[mid] == target) {
        // return mid;
        // }

        // // We have to identify which part is sorte
        // // Check if the left half is sorted

        // if (nums[left] <= nums[mid]) { // this is sorted properties
        // if (nums[left] <= target && target <= nums[mid]) {
        // right = mid - 1;
        // } else {
        // left = mid + 1;
        // }
        // } else { // right half is sorted
        // if (nums[mid] <= target && target <= nums[right]) {
        // left = mid + 1;
        // } else {
        // right = mid - 1;
        // }
        // }

        // }
        // return -1;

        // ! Optimized (Pivot + BS)
        // 1. Find the Pivot:
        // a. Use binary search to find the smallest element in the rotated array (pivot
        // point).
        // b. The pivot divides the array into two sorted parts.
        // 2. Binary Search:
        // Perform binary search in the part of the array where the target could exist.

        int n = nums.length;

        // Step 1: Find the pivot (smallest element)
        int pivot = findPivot(nums);

        // Step 2: Determine which part of the array to search
        if (nums[pivot] <= target && target <= nums[n - 1]) {
            return binarySearch(nums, pivot, n - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }

    private static int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
