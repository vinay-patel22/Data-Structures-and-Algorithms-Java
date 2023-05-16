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





// 1035. Uncrossed Lines



/* 
Time Complexity: The time complexity of this solution is O(m * n), where m is the length of nums1 and n is the length of nums2. We iterate over each element of both arrays once to fill the dp array.

Space Complexity: The space complexity is O(m * n) as well. We create a 2D dp array of size (m + 1) * (n + 1) to store the intermediate results.
*/

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Create a 2D array to store the maximum uncrossed lines
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Return the maximum uncrossed lines
        return dp[m][n];
    }
}

// 2140. Solving Questions With Brainpower


// This is standrized question of dp... i.e we have to take it or not take it..

// Method 1:- Using recursion
// Method 2:- Using memoization
// Method 3:- Using tabula (Bottom-up)



class Solution {
    public long mostPoints(int[][] questions) {
        // Get the number of questions
        int n = questions.length;
        
        // Create an array called "dp" to store the maximum points at each question index
        long[] dp = new long[n+1];
        
        // Initialize all elements of the "dp" array to 0
        Arrays.fill(dp, 0);
        
        // Iterate through the questions from the last question to the first question
        for(int i=n-1; i>=0 ;i--){
            // Get the point value of the current question
            int point = questions[i][0];
            
            // Get the jump distance of the current question
            int jump = questions[i][1];

            // Calculate the index of the next question to jump to
            // Ensure that the index does not exceed the total number of questions
            int nextQuestion = Math.min(n, i+jump+1);
            
            // Calculate the maximum number of points that can be earned starting from the current question
            // The maximum is determined by either skipping the current question or choosing to answer it
            dp[i] = Math.max(dp[i+1], point + dp[nextQuestion]);
        }
        
        // Return the maximum number of points that can be earned starting from the first question
        return dp[0];
    }
}




// 2466. Count Ways To Build Good Strings



import java.util.Arrays;

class Solution {
    int mod = (int) 1e9 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);  // short way to fill dp array with -1 without using for loop.
        for (int i = low; i <= high; i++) {
            ans = (ans + helper(i, one, zero, dp)) % mod;
        }
        return ans;
    }

    int helper(int target, int one, int zero, int[] dp) {
        // good string
        if (target == 0)
            return 1;
        // not a good string
        if (target < 0)
            return 0;
        if (dp[target] != -1)
            return dp[target];
        long sum = helper(target - one, one, zero, dp) + helper(target - zero, one, zero, dp);
        return dp[target] = (int) (sum % mod);
    }
}


// 1799. Maximize Score After N Operations

// Intuition
// The algorithm uses bit compression technique to mark the elements that have not been used yet, and then selects all possible pairs of these unselected elements to calculate their score. It does this by calling the 'gcd' function to calculate the GCD of each pair and multiplying it by the current turn number. It then recursively calls the 'dfs' function with the updated state, which removes the selected elements from the original state.

// The 'dp' array is used to memoize the results of the subproblems, so that the algorithm can avoid redundant calculations.

// Time complexity: O(2^n * n^2)
// Space complexity: O(2^n)


public class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        dp = new int[1 << n]; // Initialize the dp array with size (2^n)
        Arrays.fill(dp, 0); // Set all elements of dp array to 0
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return dfs(list, (1 << n) - 1, n / 2); // Start the DFS with full state and half of the operations remaining
    }



     int[] dp; // Array to store calculated scores for different states

    // Helper method to calculate the greatest common divisor
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Recursive method to perform DFS and calculate the maximum score
    public int dfs(List<Integer> nums, int state, int current) {
        if (current == 0) return 0; // Base case: No more operations left
        if (dp[state] != 0) return dp[state]; // Return the precalculated score for the current state if available
        int result = 0;

        // Iterate over the indices of nums
        for (int i = 0; i < nums.size(); i++) {
            if ((state & (1 << i)) == 0) continue; // Skip if the element has already been used

            // Iterate over the remaining indices
            for (int j = i + 1; j < nums.size(); j++) {
                if ((state & (1 << j)) == 0) continue; // Skip if the element has already been used

                // Calculate the current score and recursively call dfs for the next state
                result = Math.max(result, gcd(nums.get(i), nums.get(j)) * current
                        + dfs(nums, (state & (~(1 << i)) & (~(1 << j))), current - 1));
            }
        }

        dp[state] = result; // Store the calculated score for the current state
        return result;
    }


}


// 1721. Swapping Nodes in a Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode itr = head;
        int cnt=1;

    // Traverse the list until reaching the k-th node
        while(cnt++<k){
            itr = itr.next;
        }
        ListNode first = itr;
        ListNode second = head;


        while(itr.next!=null){
            itr=itr.next;
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;

    }
}





// 24. Swap Nodes in Pairs



class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode nextPair = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = swapPairs(nextPair);

        return newHead;
    }
}
