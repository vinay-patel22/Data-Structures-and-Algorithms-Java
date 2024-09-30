// Subsets :- permutations and combination
// subset means non adjacent collection

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leavel6_Subset_Subsequence_String {
    static void subSequence(String str,int index,String newString){

        if (index == str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(index);
        // to be add
        subSequence(str,index+1,newString+currChar);


        // not to be add
        subSequence(str,index+1,newString);
    }

    static void printPermutation(String str,String permutation){
        if (str.length() == 0){
            System.out.println(permutation);
            return;
        }
        for (int i=0;i<str.length();i++){
            char curr = str.charAt(i);

// below we do + str.substring(i+1) beacuse substring does not contain last index hence we do manually to increase it by 1...
            String newStr = str.substring(0,i)+str.substring(i+1);
            printPermutation(newStr,permutation+curr);
        }
    }
    public static void main(String[] args) {
        printPermutation("abc","");

//        subSequence("abc",0,"");


//        skip("","baccdah");
//        System.out.println(skip("bccdfhfgha"));
//        System.out.println(skipApple("bcdlapple"));

//        subSet("","abc");
//        subSetWithAscii("","abc");

//        System.out.println(subSetReturn("","abc"));
//        System.out.println(subSetAsciiReturn("","abc"));


//        int []arr2 = {1,2,3};
//        List<List<Integer>> ans2 = subsetArray(arr2);
//        for(List<Integer> list : ans2){
//            System.out.println(list);
//        }


//        int []arr = {1,2,2};
//        List<List<Integer>> ans = subsetArrayDuplicate(arr);
//        for(List<Integer> list : ans){
//            System.out.println(list);
//        }


    }
    static void skip(String initialString,String givenString){

        // base case..
        if(givenString.isEmpty()){
            System.out.println(initialString);
            return;
        }
        char firstChar = givenString.charAt(0);
        if (firstChar == 'a'){
            skip(initialString,givenString.substring(1));
        }else {
            skip(initialString+firstChar,givenString.substring(1));
        }
    }
    static String skip(String givenString){
        if(givenString.isEmpty()){
            return "";
        }
        char firstChar = givenString.charAt(0);
        if (firstChar == 'a'){
            return skip(givenString.substring(1));
        }else {
            return firstChar + skip(givenString.substring(1));
        }
    }
    static String skipApple(String givenString){
        if(givenString.isEmpty()){
            return "";
        }

        if (givenString.startsWith("apple")){
            return skipApple(givenString.substring(5));
        }else {
            return givenString.charAt(0) + skipApple(givenString.substring(1));
        }

    }


//    Subset question using recursion as well as iteration...

    static void subSet(String initialString,String givenString){
        if (givenString.isEmpty()){
            System.out.println(initialString);
            return;
        }
        char firstChar = givenString.charAt(0);
        subSet(initialString+firstChar,givenString.substring(1));  // call left side first
        subSet(initialString,givenString.substring(1));
    }
    static ArrayList<String> subSetReturn(String initialString, String givenString){
        if (givenString.isEmpty()){
    ArrayList<String>list = new ArrayList<>();
    list.add(initialString);
    return list;
        }
        char firstChar = givenString.charAt(0);
        ArrayList<String> left = subSetReturn(initialString+firstChar,givenString.substring(1));  // call left side first
        ArrayList<String> right = subSetReturn(initialString,givenString.substring(1));

        left.addAll(right);
        return left;
    }


    static void subSetWithAscii(String initialString,String givenString){
        if (givenString.isEmpty()){
            System.out.println(initialString);
            return;
        }
        char firstChar = givenString.charAt(0);
        subSetWithAscii(initialString+firstChar,givenString.substring(1));  // call left side first
        subSetWithAscii(initialString,givenString.substring(1));
        subSetWithAscii(initialString+(firstChar+0),givenString.substring(1));
    }
    static ArrayList<String> subSetAsciiReturn(String initialString, String givenString){
        if (givenString.isEmpty()){
            ArrayList<String>list = new ArrayList<>();
            list.add(initialString);
            return list;
        }
        char firstChar = givenString.charAt(0);
        ArrayList<String> first = subSetReturn(initialString+firstChar,givenString.substring(1));  // call left side first
        ArrayList<String> second = subSetReturn(initialString,givenString.substring(1));
        ArrayList<String> third = subSetReturn(initialString+(firstChar+0),givenString.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }


    // Using iteration using array....
    static List<List<Integer>> subsetArray(int []arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr){
            int n = outer.size();
            for (int i=0;i<n;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);

            }
        }
        return outer;
    }
    static List<List<Integer>> subsetArrayDuplicate(int []arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0;i<arr.length;i++){
            start = 0;
            if (i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for (int j=start;j<n;j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);

            }
        }
        return outer;
    }

}
