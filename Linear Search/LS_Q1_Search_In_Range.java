// Linear Search is simply search in O(n) Time Complexity.
public class LS_Q1_Search_In_Range {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int target = 5;
        // System.out.println(LinearSearch(arr,target));
        System.out.println(Search_Range(arr, target, 1, 4));
    }

    // static boolean LinearSearch(int[] arr, int target){
    // for (int i=0;i<arr.length;i++){
    // if (arr[i] == target){
    // return true;
    //// System.out.println("Target is found at index "+i);
    // }
    //
    // }
    // return false;
    // }
    static int Search_Range(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }
        for (int index = start; index <= end; index++) {
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        return -1;
    }
}
