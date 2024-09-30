import java.util.Arrays;
// It is Divide and concert method...

public class Leavel4_Merge_Sort {
    public static void main(String[] args) {
        int []arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSortInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));

    }


    static int[]mergeSort(int []arr){
        if (arr.length == 1){  // this is base case
            return arr;
        }
        int mid = arr.length / 2;  // this is how we part of array..
        int []left = mergeSort(Arrays.copyOfRange(arr,0,mid));   // solve it left side part...
        int []right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length)); // solve it right side part..

        return merge(left,right);
    }
    static int []merge(int []first,int[]second){

        // mix is take extra space --> O(n).
        int []mix = new int[first.length+second.length];   // Our final sorted array ....
        int i=0; // for left array...
        int j=0; // for right array...
        int k=0; // In our final sorted array to keep contain the element...



        // this  is how we put the sorted element in order way ...
        while (i < first.length && j < second.length){
            if (first[i]<second[j]){
                mix[k] = first[i];
                i++;
            }else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // so copy of the remaining elements

        while (i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }





    static void mergeSortInPlace(int []arr,int start,int end){
        if (end - start == 1){
            return;
        }
        int mid = (start+end)/2;
        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr,start,mid,end);
    }
    static void mergeInPlace(int[] arr, int start, int mid, int end) {
            int []mix = new int[end-start];

            int i =start;
            int j = mid;
            int k = 0;

            while (i<mid && j < end){
                if (arr[i] < arr[j]){
                    mix[k] = arr[i];
                    i++;
                }else {
                    mix[k] = arr[j];
                    j++;
                }
                k++;
            }


        // it may be possible that one of the arrays is not complete
        // so copy of the remaining elements
        while (i<mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j<end){
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0;l<mix.length;l++){
            arr[start+l] = mix[l];
        }
    }

}
