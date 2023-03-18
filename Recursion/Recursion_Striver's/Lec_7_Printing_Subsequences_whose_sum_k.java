//All Kind of Patterns in Recursion | Print All | Print one | Count

/*
1. Print All the Subsequence
2. Print all Sq which sums to K
3. Print only 1st Sq which sums to K
4. Print the count of Sq which sums to K
 */

import java.util.ArrayList;

public class Lec_7_Printing_Subsequences_whose_sum_k {
    public static void main(String[] args) {
//        int []arr={1,2,1};
//        ArrayList<Integer> ds = new ArrayList<>();
//        int n=3;
//        int sum=2;
//        f(0,ds,0,sum,arr,n);
//        f2(0,ds,0,sum,arr,n);

        int []arr={1,2,1};
        int n=3;
        int sum=2;
        System.out.println(f3(0,0,sum,arr,n));
    }

//    Print all Sq which sums to K
    public static void f(int index, ArrayList<Integer> ds, int s,int sum, int[] arr, int n) {
        if (index == arr.length){
            if (s==sum){
                System.out.println(ds);
            }
            return;
        }
//        take
        ds.add(arr[index]);
        s+=arr[index];
        f(index+1,ds,s,sum,arr,n);

//        not take
        ds.remove(ds.size()-1);
        s -= arr[index];
        f(index+1,ds,s,sum,arr,n);
    }


//    Print only 1st Sq which sums to K
public static boolean f2(int index, ArrayList<Integer> ds, int s,int sum, int[] arr, int n) {
    if (index == arr.length){
        if (s==sum){
            System.out.println(ds);
            return true;
        }
        else return false;
    }
//        take
    ds.add(arr[index]);
    s+=arr[index];
    if(f2(index+1,ds,s,sum,arr,n) == true){
        return true;
    };

//        not take
    ds.remove(ds.size()-1);
    s -= arr[index];
    if(f2(index+1,ds,s,sum,arr,n) == true){
        return true;
    };
    return false;
}

//Print the count of Sq which sums to K
public static int f3(int index, int s,int sum, int[] arr, int n) {
    if (index == arr.length){
        if (s==sum){
            return 1;
        }
        else return 0;
    }
//        take

    s+=arr[index];
    int l = f3(index+1,s,sum,arr,n);

//        not take

    s -= arr[index];
    int r=f3(index+1,s,sum,arr,n);
    return l+r;
}
}
