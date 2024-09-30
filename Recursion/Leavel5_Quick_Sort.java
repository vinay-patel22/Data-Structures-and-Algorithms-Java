import java.util.Arrays;

// pivot :- we can take any element in array as a pivot element...
// using pivot --> all small element LHS and large element in RHS...
public class Leavel5_Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        QucikSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

//        Arrays.sort(arr);

    }
    static void QucikSort(int []arr,int low,int high){
        if (low>=high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = arr[mid];
        while (start <= end){

            // also a reason why if its already sorted it will not swap..
            while (arr[start] < pivot){
                start++;
            }
            while (arr[end] > pivot){
                end--;
            }

            // Here we go to swap the element..
            if (start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            // Now my pivot is at correct index,please sort two remaing half now...

            QucikSort(arr,start,high);
            QucikSort(arr,low,end);
        }
    }

}
