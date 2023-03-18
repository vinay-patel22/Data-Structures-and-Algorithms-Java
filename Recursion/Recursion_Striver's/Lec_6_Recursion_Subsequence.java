// Time :- O(2^n)
// Space:- O(n);

import java.util.ArrayList;

public class Lec_6_Recursion_Subsequence {
    public static void main(String[] args) {
        int []arr={3,1,2};
        int n=3;
        ArrayList<Integer>ds = new ArrayList<>();
        printSubsequence(arr,0,ds);
    }

    public static void printSubsequence(int[] arr, int idx, ArrayList<Integer> ds) {
//        base case
        if (idx == arr.length){
            if (ds.size()>=0){
                System.out.println(ds);
            }
            return;
        }
        ds.add(arr[idx]); // add to the array list
        printSubsequence(arr,idx+1,ds); // pick the element
        ds.remove(ds.size()-1); // remove from the array list
        printSubsequence(arr,idx+1,ds); // not pick
    }


}
