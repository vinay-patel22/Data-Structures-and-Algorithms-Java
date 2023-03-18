// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class Q3_Smallest_Letter {
    public static void main(String[] args) {

    }

    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            // find the middle element
            // int mid = (start + end) / 2; // might be possible that (start + end) exceeds
            // the range of int in java
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // if target == 'z' and letters == ['a','b'] then answer is 'a'. ( Called wrapped around the word)
        // Because letter are wrapped around
        return letters[start % letters.length]; // JUST DO CHNAGE ONE THING..
    }
}
