package leetcode.leetcode9xx.leetcode907;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    private static final int p = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) stack.pollLast();
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) stack.pollLast();
            right[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.addLast(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) ans = ans + (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (ans % p);
    }
}
