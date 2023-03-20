// Leetcode 40


// Note: The solution set must not contain duplicate combinations.
/*
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 */


 class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans = new ArrayList<>();
        findCombi(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
    public void findCombi(int ind,int[]candidates,int target,List<List<Integer>>ans,List<Integer>ds){
//         base case
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=ind;i<candidates.length;i++){
//          skip if repeated element
            
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target)break; // Potentially found answer
            ds.add(candidates[i]);
            findCombi(i+1,candidates,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);  
            
        }
        
    }
}