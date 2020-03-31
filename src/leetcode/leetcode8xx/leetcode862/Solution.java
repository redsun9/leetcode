package leetcode.leetcode8xx.leetcode862;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int shortestSubarray(int[] a, final int k) {
        final int n = a.length;
        int res = n + 1;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + a[i];
        Deque<Integer> d = new ArrayDeque<>(a.length);
        int sumi;
        for (int i = 0; i <= n; i++) {
            sumi = sum[i];
            while (!d.isEmpty() && sumi - sum[d.peekFirst()] >= k)
                res = Math.min(res, i - d.pollFirst());
            while (!d.isEmpty() && sumi <= sum[d.peekLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= n ? res : -1;
    }
}
