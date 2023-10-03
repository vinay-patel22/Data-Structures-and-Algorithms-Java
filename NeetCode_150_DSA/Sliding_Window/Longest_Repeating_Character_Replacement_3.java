package Sliding_Window;

public class Longest_Repeating_Character_Replacement_3 {
    public static void main(String[] args) {
        
    }
    public int characterReplacement(String s, int k) {
        // Brute Force GOT TLE
        /*

        int maxLength = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int replacements = k;
                int substringLength = j - i + 1;
                
                // Count the number of replacements needed for this substring
                for (int x = i; x <= j; x++) {
                    if (s.charAt(x) != s.charAt(i)) {
                        replacements--;
                    }
                }
                
                // If we have enough replacements or no replacements needed, update maxLength
                if (replacements >= 0 || replacements + substringLength >= maxLength) {
                    maxLength = Math.max(maxLength, substringLength);
                }
            }
        }
        
        return maxLength;
        */
        
        // Sliding Window Technique
          int maxLength = 0;
        int n = s.length();
        int[] charCount = new int[26]; // Frequency of characters in the current window
        int maxCount = 0; // Maximum frequency of any character in the current window
        int start = 0; // Start of the current window
        
        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            charCount[c - 'A']++; // Increment the frequency of the current character
            maxCount = Math.max(maxCount, charCount[c - 'A']); // Update maxCount
            
            // If the number of replacements needed is greater than k, shrink the window
            if (end - start + 1 - maxCount > k) {
                charCount[s.charAt(start) - 'A']--; // Decrease frequency for the character at the start
                start++; // Shrink the window from the left
            }
            
            // Update maxLength with the current window size
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
