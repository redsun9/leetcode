package leetcode.leetcode18xx.leetcode1856;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static final int p = 1_000_000_007;

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Comparator.comparing(x -> -nums[x]));

        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        long[] sum = new long[n + 2];

        for (int i = 0; i < n; i++) pq.offer(i);
        long ans = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            int l = poll;
            int r = poll;
            long s = nums[poll];
            if (sum[l] != 0) {
                s += sum[l];
                l = left[l];
            }
            if (sum[r + 2] != 0) {
                s += sum[r + 2];
                r = right[r + 2];
            }
            ans = Math.max(ans, s * nums[poll]);
            left[l + 1] = l;
            right[l + 1] = r;
            sum[l + 1] = s;
            left[r + 1] = l;
            right[r + 1] = r;
            sum[r + 1] = s;
        }
        return (int) (ans % p);
    }
}
