import java.util.*;
public class Revision_Subset {

//    public static long[] sortColors(int[] nums) {
//        // Arrays.sort(nums);  // Brute force solution
//        int s=0;
//        int e=nums.length-1;
//        while(s<e){
//            if(nums[s] == nums[e]){
//                int temp =nums[s];
//                nums[s] = nums[e];
//                nums[e] = temp;
//            }
//            s++;
//            e--;
//            if(nums[s] < nums[e]){
//                s++;
//                e--;
//            }
//            s++;
//            e--;
//            if(nums[s] > nums[e]){
//                int temp =nums[s];
//                nums[s] = nums[e];
//                nums[e] = temp;
//            }
//            s++;
//            e--;
//        }
//        return new long[0];
//    }
public static int[] buildArray(int[] nums) {
    int ans[] = {0};
    for(int i=0;i<nums.length-1;i++){
        ans[i] = nums[nums[i]];
    }
    return nums;
}
    public static void main(String[] args) {
    int []nums = {0,2,1,5,3,4};
        System.out.println(buildArray(nums));
//        int []nums = {2,0,2,1,1,0};
//         sortColors(nums);
//        System.out.println(Arrays.toString(sortColors(nums)));


//        skipA("","bccdab");
//        System.out.println(skipA("baaaaccdab"));
//        System.out.println(skipApple("pqapplers"));
//        System.out.println(skipAppNotApple("bacapplecdah"));

    }
//    p = initial string
//    up = given string


//    Q1 Skip is a   ---> First Approach
    static void skipA(String p,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char firstChar = up.charAt(0);
        if (firstChar == 'a'){
            skipA(p,up.substring(1));
        }else {
            skipA(p+firstChar,up.substring(1));
        }
    }


    //    Q1 Skip is a   ---> Second Approach
    static String skipA(String up){
        if (up.isEmpty()){
            return "";
        }
        char firstChar = up.charAt(0);
        if (firstChar == 'a'){
            return skipA(up.substring(1));
        }else {
            return firstChar+skipA(up.substring(1));
        }
    }


    //    Q2   SKip if apple
    static String skipApple(String up){
        if (up.isEmpty()){
            return "";
        }
        char firstChar = up.charAt(0);
        if (up.startsWith("apple")){
            return skipA(up.substring(5));
        }else {
            return up.charAt(0) + skipA(up.substring(1));
        }
}


    // Q3 SKip app if not apple

    static String skipAppNotApple(String up){
        if (up.isEmpty()){
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")){
            return skipAppNotApple(up.substring(3));  // app = 3 charecter
        }
        else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }

}
