public class Q11_Factorial_Trailing_Zeroes {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {
        // 1. Brute Force Method (Time Complexity: O(n), Space Complexity: O(1))
        // TLE

        // Calculate factorial
        // long factorial = 1;
        // for (int i = 2; i <= n; i++) {
        // factorial *= i;
        // }

        // // Count trailing zeroes
        // int count = 0;
        // while (factorial % 10 == 0) {
        // count++;
        // factorial /= 10;
        // }

        // return count;

        // 2. Mathematical Optimization (Time Complexity: O(log n), Space Complexity:
        // O(1))

        // Instead of calculating the entire factorial, we can count how many times 5 is
        // a factor in numbers from 1 to n. This is because each 5 contributes a
        // trailing zero when paired with a 2, and there are more factors of 2 than 5 in
        // the factorial of n.

        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;

        // Efficient Iteration (Time Complexity: O(log n), Space Complexity: O(1))
        // This approach is similar to the previous one, but it avoids the need to
        // divide by 5 multiple times. It uses a single loop and directly counts how
        // many multiples of 5, 25, 125, etc., exist below n.

        // int count = 0;
        // for (int i = 5; i <= n; i *= 5) {
        // count += n / i;
        // }
        // return count;

    }
}
