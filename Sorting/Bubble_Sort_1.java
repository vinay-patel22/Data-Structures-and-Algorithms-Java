import java.util.Arrays;

public class Bubble_Sort_1 {
    public static void main(String[] args){
        int []arr = {5,4,3,7};
        bsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bsort(int []arr){
//        boolean flag;

        // For sorted element we took only O(N) Time Complexity.
        boolean swapped;   // If Array is already sorted then...
        for(int i=0;i<arr.length;i++){
            swapped = false;
            // for each step , max item will come at the last
            for(int j=1;j<arr.length-i;j++){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

}
