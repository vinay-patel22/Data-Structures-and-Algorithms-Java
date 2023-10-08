package NeetCode_150_DSA.Stack;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_4 {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {

        // Brute Force Approach (Generate All Combinations and Check Validity)

        // Time Complexity (Brute Force): O(2^(2n) * n), where n is the number of pairs
        // of parentheses. This is because there are 2^(2n) possible combinations, and
        // for each combination, we check if it is valid in O(n) time.
        // Space Complexity (Brute Force): O(2n), the space used for the current
        // combination.

        // List<String> result = new ArrayList<>();
        // generateAll(new char[2 * n], 0, result);
        // return result;

        // Optimized Approach (Backtracking)

        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            ans.add(current);
            return;
        }

        if (open < max) {
            backtrack(ans, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, current + ")", open, close + 1, max);
        }
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
