package Arrays_And_Hashing;
import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_Array_01 {
    public boolean containsDuplicate(int[] nums) {

        
        // Got TLE for below code
        
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_Duplicate_Array_01 solution = new Contains_Duplicate_Array_01();

        // Example usage:
        int[] inputArray = {1, 2, 3, 1}; // Replace this with your input array

        boolean result = solution.containsDuplicate(inputArray);
        System.out.println("Contains Duplicate: " + result);
    }
}
