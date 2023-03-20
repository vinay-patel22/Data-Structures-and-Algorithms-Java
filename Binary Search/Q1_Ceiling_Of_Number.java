// Celling of number = Smallest element in array greater or = target
// target na just agad no number...
// Just return start;
public class Q1_Ceiling_Of_Number {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target =2;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

        // return the index of smallest no >= target
        static int ceiling(int[] arr, int target) {

            // but what if the target is greater than the greatest number in the array
            if (target > arr[arr.length - 1]) {
                return -1;
            }
            int start = 0;
            int end = arr.length - 1;


            while(start <= end) {
                // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
                int mid = start + (end - start) / 2;

                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    // ans found
                    return mid;
                }
            }
            return start;     // JUST ONE THING TO CHANGE....
        }
    }
