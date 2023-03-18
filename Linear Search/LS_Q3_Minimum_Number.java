public class LS_Q3_Minimum_Number {
    public static void main(String[] args) {
        int []arr = {2,3,-7,6};
        System.out.println(min(arr));
    }
    static int min(int[] arr){
        int ans = arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i] < ans){
                ans = arr[i]; // Update the answer..
            }
        }
        return ans;
    }

}
