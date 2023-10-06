package Sliding_Window;

import java.util.Deque;
import java.util.LinkedList;

public class Sliding_Window_Maximum_6 {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // GOT TLE

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;

        // de-queue

        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] ans = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove element outside the sliding window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove elements smaller than the current element from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add the current idx to deque
            deque.offer(i);

            // Start recording max values when the window is fully formed
            if (i >= k - 1) {
                ans[ri++] = nums[deque.peek()];
            }
        }
        return ans;

        // Just Same thing above but small changes
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1)
                q.pollFirst();
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()])
                q.pollLast();
            q.offer(i);
            if (i >= k - 1)
                ans[j++] = nums[q.peekFirst()];
        }
        return ans;

    }
}
