package Sliding_Window;

import java.util.Arrays;

public class Permutation_in_String_4 {

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {

        // Sliding Window :- O(n)
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize the character count arrays for s1 and the initial window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Iterate through s2 with a sliding window
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }

            // Move the sliding window by decrementing the count of the character
            // that is removed from the window and incrementing the count of the
            // character that is added to the window.
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check the last window
        return Arrays.equals(s1Count, s2Count);
    }
}