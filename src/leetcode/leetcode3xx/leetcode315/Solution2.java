package leetcode.leetcode3xx.leetcode315;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    private static final int MIN_VALUE = -10_000;
    private static final int MAX_VALUE = 10_000;

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(MAX_VALUE - MIN_VALUE + 1);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            list.addFirst(tree.query(nums[i] - MIN_VALUE));
            tree.add(nums[i] - MIN_VALUE);
        }
        return list;
    }

    private static class SegmentTree {
        private static final int NEUTRAL_VALUE = 0;
        private final int n;
        private final int[] t;

        public SegmentTree(int size) {
            this.n = nextPow2(size);
            this.t = new int[n * 2 - 1];
        }

        // [0,a)
        public int query(int a) {
            return query(0, 0, n, a);
        }

        private int query(int v, int l, int r, int q) {
            if (l >= q) return NEUTRAL_VALUE;
            if (r <= q) return t[v];
            int mid = (l + r) / 2;
            return query(v * 2 + 1, l, mid, q) + query(v * 2 + 2, mid, r, q);
        }

        public void add(int a) {
            int v = n - 1 + a;
            while (v != 0) {
                t[v]++;
                v = (v - 1) >>> 1;
            }
            t[0]++;
        }
    }
}
