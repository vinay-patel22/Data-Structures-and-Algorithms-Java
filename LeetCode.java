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





// 2130. Maximum Twin Sum of a Linked List

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
    public int pairSum(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;

        // Reverse the first half of the linked list
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            ListNode nextNode = slowPtr.next;
            slowPtr.next = prevPtr;
            prevPtr = slowPtr;
            slowPtr = nextNode;
        }

        // Adjust pointers if the length of the linked list is odd
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        int maxSum = Integer.MIN_VALUE;
        while (slowPtr != null) {
            maxSum = Math.max(maxSum, slowPtr.val + prevPtr.val);
            slowPtr = slowPtr.next;
            prevPtr = prevPtr.next;
        }
        return maxSum;
    }
}




// 1557. Minimum Number of Vertices to Reach All Nodes
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
     int []tempAns = new int[n];
     for(List<Integer>edge : edges){
         tempAns[edge.get(1)]++;
     }   
     List<Integer>result = new ArrayList<>();
     for(int i=0;i<n;i++){
         if(tempAns[i]==0){
             result.add(i);
         }
     }
     return result;
    }
}



// 785. Is Graph Bipartite?

// The time complexity of the code is O(V + E), where V is the number of vertices (nodes) in the graph and E is the number of edges.


// space complexity is O(V).

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        // Iterate over each node in the graph
        for (int i = 0; i < n; i++) {
            // If the node hasn't been visited yet, perform a DFS starting from that node
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                // If the DFS returns false, indicating a violation of bipartiteness, return false
                return false;
            }
        }

        // If all nodes pass the bipartiteness check, return true
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        // If the node has been assigned a color previously, check if it matches the current color
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        // Assign the current color to the node
        colors[node] = color;

        // Explore the neighbors of the current node
        for (int neighbor : graph[node]) {
            // Recursively perform DFS on each neighbor, assigning the opposite color
            if (!dfs(graph, colors, neighbor, -color)) {
                // If any neighbor returns false, indicating a violation of bipartiteness, return false
                return false;
            }
        }

        // If all neighbors pass the bipartiteness check, return true
        return true;
    }
}





// 399. Evaluate Division



// The time complexity of the code is O(E + Q * V), where E is the number of equations, Q is the number of queries, and V is the number of nodes in the graph.

// The space complexity of the code is O(E + V), where E is the number of equations and V is the number of nodes in the graph.


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph from equations and values
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        
        // Step 2: Initialize the array to store the final answers
        double[] finalAnswers = new double[queries.size()];

        // Step 3: Iterate over each query
        for (int i = 0; i < queries.size(); i++) {
            // Get the dividend and divisor from the query
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            // Check if the graph doesn't contain either the dividend or the divisor
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                // If any of them is missing, set the result for that query as -1.0
                finalAnswers[i] = -1.0;
            } else {
                // Step 4: Perform DFS to find the result for the current query
                HashSet<String> visited = new HashSet<>();
                double[] answer = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, graph, visited, answer, temp);
                finalAnswers[i] = answer[0];
            }
        }

        // Step 5: Return the final array of answers
        return finalAnswers;
    }

    // Depth-First Search (DFS) to find the result for a query
    public void dfs(String node, String destination, HashMap<String, HashMap<String, Double>> graph,
                    HashSet<String> visited, double[] answer, double temp) {
        // If the current node has already been visited, return
        if (visited.contains(node))
            return;

        // Mark the current node as visited
        visited.add(node);

        // If the current node is the destination, update the answer and return
        if (node.equals(destination)) {
            answer[0] = temp;
            return;
        }

        // Iterate over the neighbors of the current node
        for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
            String nextNode = entry.getKey();
            double value = entry.getValue();

            // Recursive call to explore the neighbor
            dfs(nextNode, destination, graph, visited, answer, temp * value);
        }
    }

    // Build the graph from equations and values
    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        // Iterate over each equation and value
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            // Create entries for the dividend and divisor if they don't exist in the graph
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());

            // Add the directed edges with the corresponding values to the graph
            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }

        // Return the built graph
        return graph;
    }
}



// 934. Shortest Bridge


// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        boolean breakEnable = false;

        // Step 1: Find the first island using DFS and mark its cells as visited
        for (int i = 0; i < n; i++) {
            if (breakEnable)
                break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    formGraph(grid, q, i, j, n, vis, dx, dy);
                    breakEnable = true;
                    break;
                }
            }
        }

        int minimumSteps = 0;
        // Step 2: Perform BFS to find the shortest bridge to the second island
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.remove();
                for (int i = 0; i < 4; i++) {
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if (isValid(newX, newY, n)) {
                        if (!vis[newX][newY] && grid[newX][newY] == 1) {
                            return minimumSteps;
                        } else if (!vis[newX][newY] && grid[newX][newY] == 0) {
                            q.add(new int[] { newX, newY });
                            vis[newX][newY] = true;
                        }
                    }
                }
            }
            minimumSteps++;
        }

        return -1; // No bridge found
    }

    // Check if the coordinates are within the grid
    public boolean isValid(int i, int j, int n) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }

    // Use DFS to find the first island and mark its cells as visited
    public void formGraph(int[][] grid, Queue<int[]> q, int x, int y, int n, boolean[][] vis, int[] dx, int[] dy) {
        if (!isValid(x, y, n) || vis[x][y] || grid[x][y] != 1) {
            return;
        }

        q.add(new int[] { x, y });
        vis[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            formGraph(grid, q, newX, newY, n, vis, dx, dy);
        }
    }
}




// 347. Top K Frequent Elements


// Overall, the time complexity of the code is O(n + (m log m) + (k log m)), and since m ≤ n, we can simplify it to O(n + k log n).

// space complexity of the code is O(m + k).


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a HashMap to store the frequency count of each number
        Map<Integer, Integer> counter = new HashMap<>();

        // Count the frequency of each number in the input array
        for (int num : nums) {
            // Increment the count for the current number in the HashMap
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // Create a PriorityQueue to store the numbers based on their frequency
        // The PriorityQueue will order the elements in descending order of frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> counter.get(b) - counter.get(a));

        // Add all the unique numbers from the HashMap to the PriorityQueue
        for (int num : counter.keySet()) {
            heap.offer(num);
        }

        // Create an array to store the top k frequent numbers
        int[] result = new int[k];

        // Extract the top k frequent numbers from the PriorityQueue
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        // Return the array of top k frequent numbers
        return result;
    }
}


// 703. Kth Largest Element in a Stream



//  The time complexity of adding an element is O(log k) since it involves inserting an element into a priority queue (heap) with a maximum size of k. The space complexity is O(k) since the heap stores only the k largest elements.


class KthLargest {

    private PriorityQueue<Integer>heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n:nums){
            add(n);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size()>k)heap.poll();
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */






// 2542. Maximum Subsequence Score




// Time complexity: O(n∗log(n))
// Space complexity: O(n)

class Solution {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    var n = nums1.length;
    var arr = new int[n][2];

    // Create a 2D array `arr` to store pairs (nums1[i], nums2[i])
    for (var i=0; i<n; i++)
      arr[i] = new int[] {nums1[i], nums2[i]};

    // Sort the `arr` based on the second element of each pair in descending order
    Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

    long ans = 0, sum = 0;
    var heap = new PriorityQueue<Integer>();

    // Iterate over the `arr` array
    for (var i=0; i<n; i++) {
      // Add nums1[i] to the heap and update the sum
      heap.offer(arr[i][0]);
      sum += arr[i][0];

      // If the heap size is larger than k, remove the smallest element and update the sum
      if (i >= k)
        sum -= heap.poll();
      
      // If we have considered k elements, calculate the current score and update the maximum score
      if (i >= k-1)
        ans = Math.max(ans, sum * arr[i][1]);
    }
    return ans;
  }
}


// 837. New 21 Game


class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Check if Alice instantly wins or loses
        if (k == 0 || n >= k + maxPts)
            return 1.0;

        // Create an array to store the probabilities
        double[] dp = new double[n + 1];
        dp[0] = 1.0;  // Base case: Alice starts with 0 points
        double sum = 1.0;  // Cumulative sum of probabilities
        double probability = 0.0;  // Cumulative probability for totals >= k and <= n

        // Calculate probabilities using dynamic programming
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;  // Calculate the probability for current point total

            // Update the cumulative sum and probability
            if (i < k)
                sum += dp[i];
            else
                probability += dp[i];

            // Adjust the cumulative sum by removing the old probability
            if (i - maxPts >= 0)
                sum -= dp[i - maxPts];
        }

        return probability;  // Return the probability for totals >= k and <= n
    }
}



// 1140. Stone Game II


// It achieves a time complexity of O(n^2) and a space complexity of O(n^2), which is an efficient approach for solving the problem.

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        // Calculate suffix sums for efficient computation
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Initialize the dynamic programming array
        int[][] dp = new int[n][n + 1];

        // Solve the problem bottom-up using dynamic programming
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                if (2 * M >= n - i) {
                    // If 2 * M is greater than or equal to the remaining piles, Alice can take all stones
                    dp[i][M] = suffixSum[i];
                } else {
                    // Calculate the maximum number of stones Alice can obtain by considering different X values
                    for (int X = 1; X <= 2 * M; X++) {
                        dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + X][Math.max(M, X)]);
                    }
                }
            }
        }

        // The result is the maximum number of stones Alice can obtain starting from the first pile with M = 1
        return dp[0][1];
    }
}




// 1406. Stone Game III


class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[3]; // DP array to store maximum scores
        
        for (int i = n - 1; i >= 0; i--) {
            int takeOne = stoneValue[i] - dp[(i + 1) % 3]; // Score if only one stone is taken
            
            int takeTwo = Integer.MIN_VALUE;
            if (i + 1 < n)
                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 3]; // Score if two stones are taken
            
            int takeThree = Integer.MIN_VALUE;
            if (i + 2 < n)
                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 3]; // Score if three stones are taken
            
            dp[i % 3] = Math.max(Math.max(takeOne, takeTwo), takeThree); // Store maximum score for the current position
        }
        
        int value = dp[0]; // Alice's score at the start
        if (value > 0)
            return "Alice";
        else if (value < 0)
            return "Bob";
        else
            return "Tie";
    }
}



// 1547. Minimum Cost to Cut a Stick


class Solution {
    public int minCost(int n, int[] cuts) {
            // Arrays.sort(cuts);
	    	// int ans = helper1(0,n,0,cuts.length-1,cuts);
	      	// return ans;

            Arrays.sort(cuts);
		int[][] dp = new int[cuts.length][cuts.length];
		for(int i=0;i<dp.length;i++)
		{
			Arrays.fill(dp[i],-1);
		}
		int ans = helper2(0,n,0,cuts.length-1,cuts,dp,Integer.MAX_VALUE);
        return ans;

    }
    // Time Limit Exceeded (We Use Recursion)
    
    // int helper1(int x , int y , int z , int n,int[] cuts)   
	// {
	// 	if(y<=x || n < z)
	// 		return 0;
		
	// 	int ans = Integer.MAX_VALUE;
	// 	for( int i=z; i<=n; i++)
	// 	{
	// 		int currentCut = cuts[i];
	// 		int currentCost = y - x;
	// 		int left = helper(x,currentCut,z,i-1,cuts);
	// 		int right = helper(currentCut,y,i+1,n,cuts);
	// 		int cost = currentCost + left + right;
	// 		ans = Math.min(cost,ans);
	// 	}
	// 	return ans;
	// }

    // Recursion + Memoization : T.C = O(n) , S.C = O(n)+O(n)
    int helper2(int x , int y , int z , int n,int[] cuts,int [][]dp,int min){
		if(y<=x || n < z)
			return 0;
		
        if(dp[z][n] != -1){
            return dp[z][n];
        }
		int ans = Integer.MAX_VALUE;
		for( int i=z; i<=n; i++)
		{
			int currentCut = cuts[i];
			int currentCost = y - x;
			int left = helper2(x,currentCut,z,i-1,cuts,dp,min);
			int right =helper2(currentCut,y,i+1,n,cuts,dp,min);
			int cost = currentCost + left + right;
            min = Math.min(cost,min);
			dp[z][n] = min;
		}
		return min;
	}
}



// 1603. Design Parking System



/*
Approach:
The approach for the "Design Parking System" problem is to maintain a data structure that keeps track of the number of available parking spots for each car type. In this case, we can use a list or an array to store the available spots for big, medium, and small cars.

Initialize the parking system: In the constructor or initialization method, store the number of available spots for each car type in the data structure (list or array).

Add a car: In the addCar method, check if there is an available spot for the specified car type. If the number of available spots for that car type is greater than 0, decrement the count of available spots for that car type and return true to indicate a successful addition. Otherwise, return false to indicate that no parking spot is available for that car type.

Intuition:
The parking system is designed to keep track of available parking spots for different car types. By maintaining the count of available spots for each car type, we can efficiently check and manage the parking availability for incoming cars.

When initializing the parking system, we store the initial count of available spots for each car type. This allows us to keep track of the available spots throughout the parking process.

When adding a car, we check if there is an available spot for the specified car type. If so, we decrement the count of available spots for that car type and indicate a successful addition. Otherwise, we indicate that no parking spot is available for that car type.
 */

// Time and space is :- O(1)


class ParkingSystem {
    private int[] spots;  // Array to store the available spots for each car type

    // Constructor to initialize the parking system with the given number of spots for each car type
    public ParkingSystem(int big, int medium, int small) {
        spots = new int[]{big, medium, small};  // Store the available spots in the spots array
    }

    // Method to add a car to the parking system
    public boolean addCar(int carType) {
        if (spots[carType - 1] > 0) {  // If there are available spots for the given car type
            spots[carType - 1]--;  // Decrement the available spots for that car type
            return true;  // Return true to indicate successful parking
        } else {
            return false;  // Return false to indicate no available spots for that car type
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */







// 705. Design HashSet



// Time :- O(1)
// Space :- O(n)

class MyHashSet {
    private int size;                       // Number of buckets
    private List<List<Integer>> buckets;    // Buckets for storing the elements

    public MyHashSet() {
        size = 1000;                        // Default size of 1000
        buckets = new ArrayList<>(size);    // Create an ArrayList of 'size' buckets
        for (int i = 0; i < size; i++) {
            buckets.add(new LinkedList<>());    // Initialize each bucket as a LinkedList
        }
    }

    public void add(int key) {
        int index = hash(key);               // Get the index of the bucket for the given key
        List<Integer> bucket = buckets.get(index);    // Get the bucket at the calculated index
        if (!bucket.contains(key)) {
            bucket.add(key);                 // Add key to the bucket if it doesn't already exist
        }
    }

    public void remove(int key) {
        int index = hash(key);               // Get the index of the bucket for the given key
        List<Integer> bucket = buckets.get(index);    // Get the bucket at the calculated index
        bucket.remove(Integer.valueOf(key)); // Remove key from the bucket
    }

    public boolean contains(int key) {
        int index = hash(key);               // Get the index of the bucket for the given key
        List<Integer> bucket = buckets.get(index);    // Get the bucket at the calculated index
        return bucket.contains(key);        // Check if the key exists in the bucket
    }

    private int hash(int key) {
        return key % size;                   // Use the modulo operation to determine the index of the bucket
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */





// 1396. Design Underground System

// Time :- O(1)
// The space complexity is O(N + M), where N is the number of check-ins made and M is the number of unique start and end station combinations.


class UndergroundSystem {
    private Map<Integer, CheckInData> checkIns; // Track check-ins using a HashMap
    private Map<String, TimeData> travelTimes; // Track travel times using a single HashMap

    public UndergroundSystem() {
        checkIns = new HashMap<>(); // Initialize the check-ins map
        travelTimes = new HashMap<>(); // Initialize the travel times map
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t)); // Store the check-in data in the check-ins map
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData = checkIns.get(id); // Retrieve the check-in data for the given id
        String startStation = checkInData.stationName;
        int startTime = checkInData.time;

        // Calculate travel time and update the travelTimes data structure
        String routeKey = startStation + "_" + stationName; // Create a composite key for the route
        TimeData timeData = travelTimes.getOrDefault(routeKey, new TimeData()); // Retrieve or create TimeData for the route
        timeData.totalTime += t - startTime; // Update the total time by adding the difference between check-in and check-out time
        timeData.count++; // Increment the count to track the number of trips

        travelTimes.put(routeKey, timeData); // Update the travelTimes map with the updated TimeData

        checkIns.remove(id); // Remove the check-in data once check-out is recorded
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "_" + endStation; // Create the composite key for the route
        if (travelTimes.containsKey(routeKey)) {
            TimeData timeData = travelTimes.get(routeKey); // Retrieve the TimeData for the given route
            return (double) timeData.totalTime / timeData.count; // Calculate and return the average travel time
        }
        return 0.0; // If there are no records for the given route, return 0.0
    }

    // Internal class to store check-in data
    private static class CheckInData {
        private String stationName;
        private int time;

        public CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Internal class to store travel time data
    private static class TimeData {
        private int totalTime;
        private int count;
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
