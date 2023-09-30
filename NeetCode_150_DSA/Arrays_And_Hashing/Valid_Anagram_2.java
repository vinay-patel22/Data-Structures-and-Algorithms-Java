package Arrays_And_Hashing;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram_2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Count the frequency of characters in string s
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if t is an anagram of s
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Anagram_2 solution = new Valid_Anagram_2();

        // Example usage:
        String s = "anagram";
        String t = "nagaram";

        boolean result = solution.isAnagram(s, t);
        System.out.println("Is Anagram: " + result);
    }
}
