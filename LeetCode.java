// Input: nums1 = [1,2,3], nums2 = [2,4,6]
// Output: [[1,3],[4,6]]
// Explanation:
// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
  
  
// Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
// Output: [[3],[]]
// Explanation:
// For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
// Every integer in nums2 is present in nums1. Therefore, answer[1] = [].



class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
       HashSet<Integer> set1 = new HashSet<Integer>();
       HashSet<Integer> set2 = new HashSet<Integer>();
       List<List<Integer>> ans=new ArrayList<List<Integer>>();

       //iterate over nums1 and store distinct elements in set1
       for(int i=0;i<nums1.length;i++)
       {
           set1.add(nums1[i]);
       }
       
        //Iterate over nums2 and store distinct elements in set2. 
        //Also, remove matching elements of nums2 from set1
       for(int i=0;i<nums2.length;i++)
       {
           set2.add(nums2[i]);
           if(set1.contains(nums2[i]))
                set1.remove(nums2[i]);
       }

        // remove matching elements of nums1 from set2
       for(int i=0;i<nums1.length;i++)
       {
           if(set2.contains(nums1[i]))
                set2.remove(nums1[i]);
       }

        //convert set1 and set2 to answer arrayList
       ans.add(new ArrayList<Integer>(set1));
       ans.add(new ArrayList<Integer>(set2));
       return ans;
    }
}




// 649. Dota2 Senate



// For now i don`t understand what the question is say  . ?:)
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                qr.offer(i);
            } else {
                qd.offer(i);
            }
        }

        while (!qr.isEmpty() && !qd.isEmpty()) {
            int r_id = qr.poll();
            int d_id = qd.poll();
            if (r_id < d_id) {
                qr.offer(r_id + n);
            } else {
                qd.offer(d_id + n);
            }
        }

        return (qr.size() > qd.size()) ? "Radiant" : "Dire";
    }
}




// 1456. Maximum Number of Vowels in a Substring of Given Length


class Solution {
    public int maxVowels(String s, int k) {
        // Call helper function to recursively compute maximum vowel count
        return helperFun(s, k, 0, 0);
    }
    
    // Helper function to compute maximum vowel count
    private int helperFun(String s, int k, int i, int count) {
        // Base case: return current count when we have processed the entire string
        if (i == s.length()) {
            return count;
        }
        
        // Process the current character
        char c = s.charAt(i);
        int newCount = count;
        if (isVowel(c)) {
            // If the current character is a vowel, increment the count
            newCount++;
        }
        
        // If we have processed a window of size k, remove the leftmost character
        if (i >= k) {
            char removed = s.charAt(i - k);
            if (isVowel(removed)) {
                // If the removed character was a vowel, decrement the count
                newCount--;
            }
        }
        
        // Recursively compute maximum vowel count for the rest of the string
        return Math.max(newCount, helperFun(s, k, i + 1, newCount));
    }
    
    // Helper function to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}





// 1498. Number of Subsequences That Satisfy the Given Sum Condition

// Approach to solve the question 

/* 

Sort the given array nums in ascending order.
Initialize two pointers, left and right, to the first and last index of the array.
Initialize a variable count to 0.
Loop until the left pointer is less than or equal to the right pointer.
In each iteration, check if the sum of the elements at the left and right pointers is less than or equal to the target.
If the sum is less than or equal to the target, calculate the number of subsequences that can be formed by selecting the elements between the left and right pointers using the formula (2 ^ (right - left)) % (10 ^ 9 + 7).
Add the count of subsequences to the count variable.
If the sum is greater than the target, move the right pointer one index to the left.
If the sum is less than the target, move the left pointer one index to the right.
Return the count variable as the answer.

*/

// Below code is fail in the large test cases :)

// class Solution {
//     public int numSubseq(int[] nums, int target) {
//         int MOD = 1000000007; // The modulo to be used for the calculation of the final answer
//         Arrays.sort(nums); // Sort the input array in ascending order
//         int left = 0, right = nums.length - 1, count = 0; // Initialize the left and right pointers to the start and end of the array respectively, and the count to 0
//         while (left <= right) { // Loop until the left pointer is less than or equal to the right pointer
//             if (nums[left] + nums[right] > target) { // If the sum of the elements at the left and right pointers is greater than the target
//                 right--; // Move the right pointer one index to the left
//             } else { // If the sum of the elements at the left and right pointers is less than or equal to the target
//                 count = (count + (int) Math.pow(2, right - left)) % MOD; // Calculate the number of subsequences that can be formed by selecting the elements between the left and right pointers using the formula (2 ^ (right - left)) % (10 ^ 9 + 7) and add the count of subsequences to the count variable. We need to take the modulo with MOD to ensure that the value does not exceed the range of integer values.
//                 left++; // Move the left pointer one index to the right
//             }
//         }
//         return count; // Return the count variable as the answer
//     }
// }





class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, n = nums.length, l = 0, r = n - 1, mod = (int)1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1 ; i < n ; ++i)
            pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l++]) % mod;
            }
        }
        return res;
    }
}



// 1964. Find the Longest Valid Obstacle Course at Each Position





class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];  // stores the smallest ending number of an increasing subsequence
        int[] ans = new int[n]; // stores the length of the longest increasing subsequence that includes each obstacle
        
        int len = 0; // length of the longest increasing subsequence seen so far
        
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(dp, 0, len - 1, obstacles[i]); // find the position where we can add the current obstacle
            
            dp[idx] = obstacles[i]; // add the current obstacle to the dp array at the correct position
            
            if (idx == len) { // if we added the current obstacle to the end of the dp array
                len++; // update the length of the longest increasing subsequence seen so far
            }
            
            ans[i] = idx + 1; // update the length of the longest increasing subsequence that includes the i-th obstacle
        }
        
        return ans;
    }
    
    // binary search to find the position where we can add the current obstacle in the dp array
    private int binarySearch(int[] dp, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}




// 1572. Matrix Diagonal Sum



// The time complexity of this implementation is O(n), where n is the size of the matrix, and the space complexity is O(1), as it only uses a constant amount of additional memory.


class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        
        // iterate over the primary diagonal
        for(int i=0;i<mat.length;i++){
            sum += mat[i][i];
        }

        // iterate over the secondary diagonal
        for(int i=0;i<mat.length;i++){
            sum += mat[i][mat.length-i-1];
        }

        // if the matrix is odd-sized,subtract the center element
        if(mat.length % 2 == 1){
            sum -= mat[mat.length/2][mat.length/2];
        }

        return sum;
    }
}



// 54. Spiral Matrix




class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer>ans=new ArrayList<Integer>();

        if(matrix.length==0){
            return ans;
        }
        int top=0,left=0;
        int bottom=matrix.length-1,right=matrix[0].length-1;

        while(top<=bottom && left<=right){
            // top row
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // right column
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;

            // bottom row
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // left colum

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
        return ans;
    }
}

// 59. Spiral Matrix II


class Solution {
    public int[][] generateMatrix(int n) {


        int[][] answerMatrix = new int[n][n];
        int num = 1;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Fill the top row
            for (int col = colStart; col <= colEnd; col++) {
                answerMatrix[rowStart][col] = num++;
            }
            rowStart++;
            
            // Fill the right column
            for (int row = rowStart; row <= rowEnd; row++) {
                answerMatrix[row][colEnd] = num++;
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {
                // Fill the bottom row
                for (int col = colEnd; col >= colStart; col--) {
                    answerMatrix[rowEnd][col] = num++;
                }
                rowEnd--;
            }
            
            if (colStart <= colEnd) {
                // Fill the left column
                for (int row = rowEnd; row >= rowStart; row--) {
                    answerMatrix[row][colStart] = num++;
                }
                colStart++;
            }
        }
        
        return answerMatrix;
    }
}
