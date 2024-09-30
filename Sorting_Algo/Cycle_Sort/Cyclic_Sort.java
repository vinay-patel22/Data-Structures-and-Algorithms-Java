// Repetitive Pattern --> Amazon,Google,Facebook

// Here we have to solve using one pass only.
// check .... swap .... move...
// --> When give numbers from range 1,N => Use Cyclic Sort

import java.util.Arrays;

public class Cyclic_Sort {
    public static void main(String[] args) {
    int[] arr = {3,5,2,1,4};
    cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void cyclicSort(int[]arr){
        int i=0;
        while (i<arr.length){
            int correctIndex = arr[i] - 1;  // index = value - 1;
            if (arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else {
                i++;
            }
        }
    }
    static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
