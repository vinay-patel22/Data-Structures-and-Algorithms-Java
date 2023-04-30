// Java program for a linear time
// solution for stock span problem
// without using stack
 
import java.io.*;
 
class GFG {
 
    // An efficient method to calculate
    // stock span values implementing the
    // same idea without using stack
    static void calculateSpan(int A[], int n, int ans[])
    {
        // Span value of first element is always 1
        ans[0] = 1;
 
        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {
            int counter = 1;
            while ((i - counter) >= 0
                   && A[i] >= A[i - counter]) {
                counter += ans[i - counter];
            }
            ans[i] = counter;
        }
    }
 
    // A utility function to print elements of array
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];
 
        // Fill the span values in array S[]
        calculateSpan(price, n, S);
 
        // print the calculated span values
        printArray(S, n);
    }
}







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
