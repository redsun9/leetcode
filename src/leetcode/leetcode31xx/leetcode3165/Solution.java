package leetcode.leetcode31xx.leetcode3165;

import static java.lang.Math.max;

public class Solution {
    private static final long p = 1_000_000_007;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        SegmentTree tree = new SegmentTree(nums);
        long ans = 0;
        for (int[] query : queries) ans += tree.update(query[0], query[1]);
        return (int) (ans % p);
    }

    private static class SegmentTree {
        final long[][] t;
        final int n;

        SegmentTree(int[] nums) {
            n = nextPow2(nums.length);
            t = new long[n * 2 - 1][4];
            for (int i = 0, j = n - 1; i < nums.length; i++, j++) t[j][3] = Math.max(nums[i], 0);
            for (int i = n - 2, i1 = i * 2 + 1, i2 = i * 2 + 2; i >= 0; i--, i1 -= 2, i2 -= 2) t[i] = f(t[i1], t[i2]);
        }

        public long update(int pos, int value) {
            update(pos, value, 0, 0, n);
            return t[0][3];
        }

        private void update(int pos, int value, int v, int l, int r) {
            if (l == r - 1) t[v] = new long[]{0, 0, 0, max(value, 0)};
            else {
                int mid = (l + r) / 2;
                if (pos < mid) update(pos, value, v * 2 + 1, l, mid);
                else update(pos, value, v * 2 + 2, mid, r);
                t[v] = f(t[v * 2 + 1], t[v * 2 + 2]);
            }
        }
    }

    private static long[] f(long[] a, long[] b) {
        return new long[]{
                max(a[0] + b[2], a[1] + b[0]),
                max(a[0] + b[3], a[1] + b[1]),
                max(a[2] + b[2], a[3] + b[0]),
                max(a[2] + b[3], a[3] + b[1])
        };
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
