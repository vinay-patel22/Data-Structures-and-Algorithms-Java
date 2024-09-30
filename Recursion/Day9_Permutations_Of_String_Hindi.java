import java.util.Arrays;
import java.util.List;

import static java.util.Collections.addAll;

public class Day9_Permutations_Of_String_Hindi {
    public static void main(String[] args) {

//                nums = [0,1,2,3,4], index = [0,1,2,2,1]
//        Output: [0,4,1,3,2]
    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        for(int i=0;i<items.size();i++){
            if(ruleKey.getChars(i)  && items.get(i) == ruleValue){
                count++;
            }
        }
        return count;
    }
    }
    /*
//    Q1  i/p = "abc"   --> Total n! permutations..
//        o/p = abc acb bac bca cab cba
    static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = null;
        int index = 0;
        solve(nums,ans,index);
        return ans;
     }
    static void solve(int[] nums, List<List<Integer>>ans, int index){
        // base case
        if (index >= nums.size()){
            addAll(nums);
            return;
        }
        for (int j=index;j<nums.size();j++){
            swap(nums[index], nums[j];
            solve(nums,ans,index);
            // backtrack
            swap(nums.get(index), nums.get(j));
        }
    }

    private static void addAll(int[] nums) {
    }

    private static void swap(Integer integer, Integer integer1) {
        int temp = integer;
        integer = integer1;
        integer1 =temp;
    }

     */
}
