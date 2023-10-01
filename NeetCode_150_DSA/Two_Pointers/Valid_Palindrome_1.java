package NeetCode_150_DSA.Two_Pointers;

import java.util.Scanner;

public class Valid_Palindrome_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call the isPalindrome method
        Valid_Palindrome_1 solution = new Valid_Palindrome_1();
        boolean result = solution.isPalindrome(input);

        // Output
        if (result) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }

        scanner.close();
    }

    public boolean isPalindrome(String s) {
        // Brute Force
        // This approach has a time complexity of O(n), where n is the length of the
        // string, and
        // a space complexity of O(n) for storing the reversed string

        // s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // StringBuilder reversed = new StringBuilder(s).reverse();

        // return s.equals(reversed.toString());

        // Two Pointer Approach
        // Time :- O(n) , Space:-O(1)

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

        // Another Method
        // int i = 0;
        // int j = s.length() - 1;
        // while (i < j) {

        // Character start = s.charAt(i);
        // Character end = s.charAt(j);

        // if (!Character.isLetterOrDigit(start)) {
        // i++;
        // continue;
        // }

        // if (!Character.isLetterOrDigit(end)) {
        // j--;
        // continue;
        // }

        // if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
        // return false;
        // }

        // i++;
        // j--;
        // }

        // return true;
    }
}
