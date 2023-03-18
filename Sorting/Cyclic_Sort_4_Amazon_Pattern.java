import java.util.Arrays;

public class Cyclic_Sort_4_Amazon_Pattern {
    public static void main(String[] args) {
        int []arr = {3,5,2,1,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int []arr){
        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i] - 1;  // index = value-1
            if (arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else {
                i++;
            }
        }
    }
    static void swap(int []arr,int first,int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }



    // Q1 :- Find Missing Number
    
}
