import java.util.Arrays;

public class Leetcode_Plus_One {
    public static void main(String[] args) {
        int[] arr = {3,22,1,67,89,9};
        // 1,3,9,22,67,89
        // int k =3;
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
//        int i=0;
//                for(i=0;i<digits.length-1;i++){
//                    if (digits[i]== digits.length-1){
//                        int[] newArr = new int[digits.length + 1];
//                        newArr[0] = 1;
//                        return newArr;
//                    }
//                }
        // Without Recursion
         for (int i = digits.length - 1; i >= 0; i--) {
             if (digits[i] < 9) {
                 digits[i]++;
                 return digits;
             }
             digits[i] = 0;
         }
         int[] newArr = new int[digits.length + 1];
         newArr[0] = 1;
         return newArr;

    }
}
