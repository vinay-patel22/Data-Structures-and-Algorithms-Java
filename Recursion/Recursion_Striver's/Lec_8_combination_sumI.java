// Leetcode 39
/* 
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

*/

// TCom.:- 2^t * k
// SCom:- k * x (k=auxilary space and x is number of combination)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
        findCombi(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void findCombi(int ind,int[]arr,int target, List<List<Integer>>ans,List<Integer>ds){
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            findCombi(ind,arr,target-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombi(ind+1,arr,target,ans,ds);
    }
}