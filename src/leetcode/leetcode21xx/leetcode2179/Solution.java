package leetcode.leetcode21xx.leetcode2179;

public class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] map = new int[n];
        for (int i = 0; i < n; i++) map[nums2[i]] = i;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = map[nums1[i]];

        int[] left = new int[n];
        SegmentTree stLeft = new SegmentTree(n);
        for (int i = 0; i < n; i++) {
            left[i] = stLeft.query(0, nums[i]);
            stLeft.increase(nums[i]);
        }

        int[] right = new int[n];
        SegmentTree stRight = new SegmentTree(n);
        for (int i = n - 1; i >= 0; i--) {
            right[i] = stRight.query(nums[i] + 1, n);
            stRight.increase(nums[i]);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) left[i] * right[i];
        }
        return ans;
    }

    private static class SegmentTree {
        final int[] t;
        final int n;

        SegmentTree(int n) {
            n = nextPow2(n);
            this.n = n;
            this.t = new int[n * 2];
        }

        void increase(int pos) {
            pos += n;
            t[pos] = 1;
            pos >>= 1;
            while (pos != 0) {
                t[pos]++;
                pos >>= 1;
            }
        }

        public int query(int a, int b) {
            return query(1, 0, n, a, b);
        }

        private int query(int v, int l, int r, int ql, int qr) {
            if (l >= qr || r <= ql) return 0;
            if (ql <= l && r <= qr) return t[v];
            int mid = (l + r) / 2;
            return query(v << 1, l, mid, ql, qr) + query(v << 1 | 1, mid, r, ql, qr);
        }
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
