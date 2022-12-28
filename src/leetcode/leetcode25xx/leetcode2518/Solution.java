package leetcode.leetcode25xx.leetcode2518;

import java.util.Arrays;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        long sum = 0;
        int[] prev = new int[k + 1], next = new int[k + 1], tmp;
        prev[0] = 1;
        for (int num : nums) {
            Arrays.fill(next, 0);
            for (int l = 0; l <= k; l++) {
                long r = sum - l;
                if (r < l) break;
                int nextL = (int) Math.min(k, Math.min(l + num, r));
                next[nextL] += prev[l];
                if (next[nextL] >= p) next[nextL] -= p;

                next[l] += prev[l];
                if (next[l] >= p) next[l] -= p;
            }
            sum += num;
            tmp = prev;
            prev = next;
            next = tmp;

        }
        return prev[k];
    }
}
