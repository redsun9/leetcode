package leetcode.leetcode24xx.leetcode2407;

public class Solution {
    private static final int MAX_VAL = 100_000;

    public int lengthOfLIS(int[] nums, int k) {
        SegmentTree st = new SegmentTree(MAX_VAL + 1);
        int ans = 0;
        for (int num : nums) {
            int fromVal = st.query(num - k, num);
            int prevVal = st.query(num);
            if (prevVal < fromVal + 1) {
                ans = Math.max(ans, fromVal + 1);
                st.update(num, fromVal + 1);
            }
        }
        return ans;
    }

    private static class SegmentTree {
        final int[] t;
        final int n;

        public SegmentTree(int n) {
            n = nextPow2(n);
            this.n = n;
            this.t = new int[n * 2];
        }

        void update(int pos, int value) {
            pos += n;
            t[pos] = value;
            pos >>= 1;
            while (pos != 0) {
                t[pos] = Math.max(t[pos << 1], t[pos << 1 | 1]);
                pos >>= 1;
            }
        }

        public int query(int a) {
            return t[n + a];
        }

        public int query(int a, int b) {
            return query(1, 0, n, a, b);
        }

        private int query(int v, int l, int r, int ql, int qr) {
            if (l >= qr || r <= ql) return 0;
            if (ql <= l && r <= qr) return t[v];
            int mid = (l + r) / 2;
            return Math.max(query(v << 1, l, mid, ql, qr), query(v << 1 | 1, mid, r, ql, qr));
        }
    }


    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

}