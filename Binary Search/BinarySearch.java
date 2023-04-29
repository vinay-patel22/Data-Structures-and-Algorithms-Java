//Find minimum number K such that its factorial is multiple of N



import java.util.*;

class Solution {

	// To avoid overflow
	static long MAX_VALUE = (long)1e13;

	// Check function of binary search
	static boolean test(long mid, Map<Long, Long> mp)
	{

		// Every number that divides N
		// compared with Mid whether it
		// also divides Mid
		for (Map.Entry<Long, Long> e : mp.entrySet()) {

			// cnt stores number of times mid
			// factorial can be divided with
			// e.getKey() (which is number that
			// also divides N e.getValue() times)
			long cnt = 0;

			// Iterating till power of 30
			for (long i = 1; i <= 30; i++) {

				// Number theory formula
				long temp = (long)Math.floor(
					mid / Math.pow(e.getKey(), i));

				// If temp is zero we can
				// break it out to speed
				// up the program
				if (temp == 0)
					break;

				// Adding temp to count
				cnt += temp;
			}

			// If number of times N is divided
			// by e.getKey() greater than mid
			// factorial that means mid factorial
			// is not divisible by N return false
			if (e.getValue() > cnt)
				return false;
		}

		// Otherwise return true
		return true;
	}

	// Function to find minimum value of K
	// such that K! is multiple of N
	static long findMinK(long N)
	{

		// Step 1 : Finding all prime divisors
		// of N and their powers
		// Hash map to store prime divisors
		// with its powers
		Map<Long, Long> mp = new HashMap<Long, Long>();

		// Count the number of times 2 divides
		long count = 0;
		while (N % 2 == 0) {

			// N divide by 2
			N /= 2;

			// Increasing the counter
			count++;
		}

		// If 2 divides it
		if (count != 0)
			mp.put((long)2, count);

		// Check for all the possible numbers
		// that can divide it
		for (long i = 3; i <= Math.sqrt(N); i += 2) {

			// Resetting count to zero
			count = 0;

			// Divide it until possible
			while (N % i == 0) {

				// Increasing the counter
				count++;

				// Divide it by i
				N /= i;
			}

			// If count is non zero then
			if (count != 0)
				mp.put(i, count);
		}

		// If n at the end is a prime number.
		if (N > 2)
			mp.put(N, (long)1);

		// Step 2 : Binary Search on answer K
		// low pointer on 2 and high on
		// maximum value
		long low = 2, high = MAX_VALUE;

		// While high is greater than to 1
		while (high - low > 1) {

			// mid value
			long mid = (high + low) / 2;

			// Checking for mid value
			if (test(mid, mp)) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}

		// If check function is true for
		// low then return low
		if (test(low, mp))
			return low;

		// Else return high
		else
			return high;
	}

	// Driver Code
	public static void main(String[] args)
	{

		// Input 1
		int N = 30;

		// Function Call
		System.out.println(findMinK(N));
	}
}




public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 22;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }
    // return the index
    // return -1 if it does not exist
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
}
