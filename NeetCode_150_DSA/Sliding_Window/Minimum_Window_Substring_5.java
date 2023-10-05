package Sliding_Window;

public class Minimum_Window_Substring_5 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {

        // Brute Force Solution Time :- O(m^3 * n)
        // TLE
        /* 
        int m = s.length();
        int n = t.length();
        String minWindow = "";

        for (int start = 0; start < m; start++) {
            for (int end = start + n; end <= m; end++) {
                String window = s.substring(start, end);
                if (containsAllChars(window, t) && (minWindow.isEmpty() || window.length() < minWindow.length())) {
                    minWindow = window;
                }
            }
        }

        return minWindow;
    }

    private boolean containsAllChars(String s, String t) {
        int[] charCount = new int[128];

        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        for (char c : s.toCharArray()) {
            if (charCount[c] > 0) {
                charCount[c]--;
            }
        }

        for (int count : charCount) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
    */

    // Most Optimized solution

    int[] tCount = new int[128]; // Count of characters in t
    int requiredChars = t.length(); // Number of unique characters required
    int minLen = Integer.MAX_VALUE;
    int minStart = 0;
    int start = 0;
    
    // Initialize character counts for t
    for (char c : t.toCharArray()) {
        tCount[c]++;
    }
    
    for (int end = 0; end < s.length(); end++) {
        // Decrement the count for the current character in s
        if (tCount[s.charAt(end)] > 0) {
            requiredChars--;
        }
        tCount[s.charAt(end)]--;
        
        // While all required characters are found, try to minimize the window
        while (requiredChars == 0) {
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
                minStart = start;
            }
            
            // Increment the count for the character at the start of the window
            tCount[s.charAt(start)]++;
            if (tCount[s.charAt(start)] > 0) {
                requiredChars++;
            }
            
            // Move the window start to the right
            start++;
        }
    }
    
    return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
}