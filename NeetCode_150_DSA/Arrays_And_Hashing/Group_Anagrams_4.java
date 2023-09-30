package Arrays_And_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams_4 {
    public static void main(String[] args) {
        System.out.println("Visit The Leetcode !");
        // https://leetcode.com/problems/group-anagrams/
    }
      public List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap to store groups of anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Count the frequency of each character in the string
            int[] charCount = new int[26]; // Assuming lowercase English letters
            
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            
            // Convert the character count array to a unique key string
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count);
                keyBuilder.append('#'); // Use a delimiter to separate counts
            }
            
            String key = keyBuilder.toString();
            
            // Check if the key is already in the hashmap
            // If not, create a new list; otherwise, add to the existing list
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // Convert the hashmap values to a list of lists
        List<List<String>> ans = new ArrayList<>(anagramGroups.values());
        
        return ans;
    }
}
