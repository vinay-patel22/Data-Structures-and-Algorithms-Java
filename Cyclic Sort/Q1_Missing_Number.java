// Amazon Question
// Je Number missing hoy ae find karvano..

import java.util.Arrays;

/*
    Ex.  N = 4 , arr = [4 , 0 , 2 , 1]
    Here we know that original things happen like this... [0 , 1, 2, 3, 4]
    Output :- 3      // Because 3 is Missing here

// Here N index not exit.... ok so Ignore this..
// Element == Index then it is our answer.... If not then It is missing number..

 */
public class Q1_Missing_Number {
    public static void main(String[] args) {
//        int [] arr = {3,0,1};
        int [] arr = {4,0,2,1};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[]arr){
        int i=0;
        while (i<arr.length){
            int correctIndex = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else {
                i++;
            }
        }
        // search for first missing number
        for(int index=0;index<arr.length;index++){
            if (arr[index] != index){
                return index;
            }
        }

        // case 2
        return arr.length;
    }
    static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
