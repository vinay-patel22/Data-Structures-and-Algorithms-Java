import java.util.Arrays;

public class Q1_Swap {
    public static void main(String[] args) {
        int []arr = {2,4,6,8,1,3};
        System.out.println(Arrays.toString(swap(arr,0,3)));
    }
    public static int[] swap(int[]arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

}
