public class LS_LeetCode_Q5_Even_Digit_Number {
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7898 };
        System.out.println(findNumbers(nums));

        // System.out.println(digits(123456));
        // System.out.println(even(4567));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }
        return count;
    }

    // Below function check whether number is even or not?
    static boolean even(int num) {
        int numberOfDigits = digits(num);
        if (numberOfDigits % 2 == 0) {
            return true;
        }
        return false;

    }

    // count number of digits in a number
    static int digits(int num) { // This case for negative number
        if (num < 0) {
            num = num * -1;  // here how i make the number is positive..
        }

        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10; // num = num / 10
        }
        return count;
    }

    static int digits2(int num) {

        if (num < 0) {
            num = num * -1;
        }

        // short cut to find number of digit
        return (int) (Math.log10(num)) + 1;

    }
}
