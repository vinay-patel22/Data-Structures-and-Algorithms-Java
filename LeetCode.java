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

