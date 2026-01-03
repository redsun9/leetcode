package leetcode.leetcode37xx.leetcode3721;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> lastPosition = new HashMap<>();
        SegmentTree segmentTree = new SegmentTree(n);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int last = lastPosition.getOrDefault(nums[i], -1);
            segmentTree.update(last + 1, i + 1, (nums[i] & 1) == 0 ? 1 : -1);
            int query = segmentTree.query();
            if (query != -1 && query < i) ans = Math.max(ans, i - query + 1);
            lastPosition.put(nums[i], i);
        }
        return ans;
    }

    private static class SegmentTree {
        private final int n;
        private final int[] minBalance, maxBalance;
        private final int[] toUpdate;

        public SegmentTree(int n) {
            this.n = nextPow2(n);
            this.minBalance = new int[this.n * 2 - 1];
            this.maxBalance = new int[this.n * 2 - 1];
            this.toUpdate = new int[this.n * 2 - 1];
        }

        public int query() {
            return query(0, 0, n);
        }

        private int query(int v, int l, int r) {
            pushChange(v, l, r);
            if (0 < minBalance[v] || 0 > maxBalance[v]) return -1;
            if (l == r - 1) return minBalance[v] == 0 ? l : -1;
            int mid = (l + r) / 2;
            int left = query(v * 2 + 1, l, mid);
            if (left != -1) return left;
            return query(v * 2 + 2, mid, r);
        }

        public void update(int from, int to, int change) {
            update(0, 0, n, from, to, change);
        }

        private void update(int v, int l, int r, int from, int to, int change) {
            pushChange(v, l, r);
            if (l >= to || r <= from) return;
            if (from <= l && r <= to) {
                toUpdate[v] = change;
                pushChange(v, l, r);
            } else {
                int mid = (l + r) / 2;
                update(v * 2 + 1, l, mid, from, to, change);
                update(v * 2 + 2, mid, r, from, to, change);
                minBalance[v] = Math.min(minBalance[v * 2 + 1], minBalance[v * 2 + 2]);
                maxBalance[v] = Math.max(maxBalance[v * 2 + 1], maxBalance[v * 2 + 2]);
            }
        }

        private void pushChange(int v, int l, int r) {
            if (toUpdate[v] != 0) {
                minBalance[v] += toUpdate[v];
                maxBalance[v] += toUpdate[v];
                if (l != r - 1) {
                    toUpdate[v * 2 + 1] += toUpdate[v];
                    toUpdate[v * 2 + 2] += toUpdate[v];
                }
                toUpdate[v] = 0;
            }
        }

    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
