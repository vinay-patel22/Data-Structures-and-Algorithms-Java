package Sliding_Window;

public class Longest_Substring_Without_Repeating_Characters_2 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        // Brute Force we got TLE

        /* 
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;

        // O(n^2) using a sliding window technique

        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            Set<Character> charSet = new HashSet<>();
            int j = i;

            while (j < n && !charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
        */
        
        // more optimized solution that should perform better than the current one in
        // terms of runtime. One way to improve the performance is to use a sliding
        // window with a more efficient mechanism for tracking and skipping repeated
        // characters

        // 1ms Fast Run Time
        int maxLength = 0;
        int n = s.length();
        int[] charIndex = new int[128]; // To store the most recent index of each character

        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            i = Math.max(charIndex[c], i); // Move i to the right of the last occurrence of c
            maxLength = Math.max(maxLength, j - i + 1);
            charIndex[c] = j + 1; // Update the index of the character
        }

        return maxLength;
    }

    /* 
    private boolean isUnique(String s, int start, int end) {
        Set<Character> charSet = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (charSet.contains(c)) {
                return false;
            }
            charSet.add(c);
        }
        return true;

        */
    

}
